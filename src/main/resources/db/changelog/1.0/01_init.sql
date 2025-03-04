CREATE TABLE payment_status
(
    id   INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

COMMENT ON TABLE payment_status IS 'Payment statuses';
COMMENT ON COLUMN payment_status.id IS 'Unique identifier for the payment status';
COMMENT ON COLUMN payment_status.name IS 'Name of the payment status';

CREATE TABLE payment
(
    id                BIGSERIAL PRIMARY KEY,
    payment_status_id INT       NOT NULL,
    creation_date     TIMESTAMP NOT NULL DEFAULT NOW(),
    update_date       TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT payment_status_id_fk FOREIGN KEY (payment_status_id) REFERENCES payment_status (id)
);

COMMENT ON TABLE payment IS 'Payment information';
COMMENT ON COLUMN payment.id IS 'Unique identifier for the payment';
COMMENT ON COLUMN payment.payment_status_id IS 'Identifier of the payment status';
COMMENT ON COLUMN payment.creation_date IS 'Date of creation';
COMMENT ON COLUMN payment.update_date IS 'Date of the last update';

CREATE TABLE payment_info
(
    id             BIGSERIAL PRIMARY KEY,
    user_id        BIGINT         NOT NULL,
    payment_id     BIGINT         NOT NULL,
    order_id       BIGINT         NOT NULL,
    total_price    NUMERIC(10, 2) NOT NULL,
    payment_system VARCHAR(100)   NOT NULL,
    currency       VARCHAR(100)   NOT NULL,
    CONSTRAINT payment_id_fk FOREIGN KEY (payment_id) REFERENCES payment (id)
);

COMMENT ON TABLE payment_info IS 'Detailed payment information';
COMMENT ON COLUMN payment_info.id IS 'Unique identifier for the payment info';
COMMENT ON COLUMN payment_info.user_id IS 'Identifier of the user making the payment';
COMMENT ON COLUMN payment_info.payment_id IS 'Identifier of the payment';
COMMENT ON COLUMN payment_info.order_id IS 'Identifier of the associated order';
COMMENT ON COLUMN payment_info.total_price IS 'Total amount paid';
COMMENT ON COLUMN payment_info.payment_system IS 'Payment system used';
COMMENT ON COLUMN payment_info.currency IS 'Currency of the payment';

CREATE TABLE payment_status_history
(
    id            BIGSERIAL PRIMARY KEY,
    payment_id    BIGINT    NOT NULL,
    old_status_id INT       NOT NULL,
    change_date   TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT payment_id_fk FOREIGN KEY (payment_id) REFERENCES payment (id),
    CONSTRAINT old_status_id_fk FOREIGN KEY (old_status_id) REFERENCES payment_status (id)
);

COMMENT ON TABLE payment_status_history IS 'Payment status change history';
COMMENT ON COLUMN payment_status_history.id IS 'Unique identifier for the payment status change record';
COMMENT ON COLUMN payment_status_history.payment_id IS 'Identifier of the payment';
COMMENT ON COLUMN payment_status_history.old_status_id IS 'Previous status of the payment';
COMMENT ON COLUMN payment_status_history.change_date IS 'Date of the status change';
