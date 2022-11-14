CREATE SCHEMA IF NOT EXISTS challenge;
CREATE SCHEMA IF NOT EXISTS challenge_test;

CREATE TABLE IF NOT EXISTS alerts
(
    id                      SERIAL           PRIMARY KEY,
    type                    INT              NOT NULL,
    machine                 VARCHAR(100)     NOT NULL,
    detection_time          TIMESTAMP        NOT NULL,
    anomaly_output_path     VARCHAR(255),
    normal_output_path      VARCHAR(255),
    comment                 VARCHAR(512),
    reason                  VARCHAR(50),
    action                  VARCHAR(50)
);

INSERT INTO alerts (type, machine, detection_time, anomaly_output_path, normal_output_path)
values (1, 'CNC Machine', to_timestamp(1628676001), 'audio/1.wav', 'audio/1.wav'),
       (2, 'CNC Machine', to_timestamp(1629102961), 'audio/2.wav', 'audio/2.wav'),
       (3, 'CNC Machine', to_timestamp(1629058322), 'audio/3.wav', 'audio/3.wav'),
       (1, 'Milling Machine', to_timestamp(1629057722), 'audio/4.wav', 'audio/4.wav'),
       (2, 'Milling Machine', to_timestamp(1629025202), 'audio/5.wav', 'audio/5.wav'),
       (3, 'Milling Machine', to_timestamp(16290573619), 'audio/6.wav', 'audio/6.wav');

