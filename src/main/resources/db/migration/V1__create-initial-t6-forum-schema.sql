CREATE TABLE answers
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    message       VARCHAR(255)          NOT NULL,
    register_date datetime              NOT NULL,
    last_update datetime              NOT NULL,
    solution      VARCHAR(255)          NULL,
    user_id       BIGINT                NULL,
    topic_id      BIGINT                NULL,
    CONSTRAINT pk_answers PRIMARY KEY (id)
);

CREATE TABLE courses
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NOT NULL,
    category VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_courses PRIMARY KEY (id)
);

CREATE TABLE profiles
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_profiles PRIMARY KEY (id)
);

CREATE TABLE topics
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NOT NULL,
    message       VARCHAR(255)          NOT NULL,
    register_date datetime              NOT NULL,
    last_update datetime              NOT NULL,
    status        BIT(1)                NOT NULL,
    user_id       BIGINT                NULL,
    curso_id      BIGINT                NULL,
    CONSTRAINT pk_topics PRIMARY KEY (id)
);

CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    nickname VARCHAR(255)          NOT NULL,
    email    VARCHAR(255)          NOT NULL,
    password VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE users_profiles
(
    profiles_id BIGINT NOT NULL,
    users_id    BIGINT NOT NULL
);

ALTER TABLE profiles
    ADD CONSTRAINT uc_profiles_name UNIQUE (name);

ALTER TABLE topics
    ADD CONSTRAINT uc_topics_title UNIQUE (title);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE answers
    ADD CONSTRAINT FK_ANSWERS_ON_TOPIC FOREIGN KEY (topic_id) REFERENCES topics (id);

ALTER TABLE answers
    ADD CONSTRAINT FK_ANSWERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE topics
    ADD CONSTRAINT FK_TOPICS_ON_CURSO FOREIGN KEY (curso_id) REFERENCES courses (id);

ALTER TABLE topics
    ADD CONSTRAINT FK_TOPICS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users_profiles
    ADD CONSTRAINT fk_usepro_on_profile FOREIGN KEY (profiles_id) REFERENCES profiles (id);

ALTER TABLE users_profiles
    ADD CONSTRAINT fk_usepro_on_user FOREIGN KEY (users_id) REFERENCES users (id);

-- Migration to add initial profiles

INSERT INTO profiles (name) VALUES ('admin');
INSERT INTO profiles (name) VALUES ('user');