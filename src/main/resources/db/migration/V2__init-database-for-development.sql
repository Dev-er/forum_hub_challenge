-- Migration to add initial users

INSERT INTO users (id, name, email, password) VALUES(
    1, 'Lucas', 'lucas@exemplo.com', '$2a$12$D.e3i/w.yzMCttmmivk7EuXzIIsJhw/i7I8QIwlCoV8bU1Q4Q1QqC'
);

INSERT INTO users (id, name, email, password) VALUES(
    2, 'Flora', 'flora@exemplo.com', '$2a$12$D.e3i/w.yzMCttmmivk7EuXzIIsJhw/i7I8QIwlCoV8bU1Q4Q1QqC'
);

-- Migration to add initial course

INSERT INTO courses (name, category) VALUES ('Java', 'Backend');
INSERT INTO courses (name, category) VALUES ('Nodejs', 'Backend');
INSERT INTO courses (name, category) VALUES ('C', 'Backend');
INSERT INTO courses (name, category) VALUES ('C++', 'Backend');
INSERT INTO courses (name, category) VALUES ('Rust', 'Backend');
INSERT INTO courses (name, category) VALUES ('PHP', 'Backend');
INSERT INTO courses (name, category) VALUES ('Java', 'Backend');
INSERT INTO courses (name, category) VALUES ('C#', 'Backend');
INSERT INTO courses (name, category) VALUES ('Ruby', 'Backend');
INSERT INTO courses (name, category) VALUES ('Kotlin', 'Backend');

INSERT INTO courses (name, category) VALUES ('JavaScript', 'Frontend');
INSERT INTO courses (name, category) VALUES ('Bootstrap', 'Frontend');
INSERT INTO courses (name, category) VALUES ('Tailwind', 'Frontend');
INSERT INTO courses (name, category) VALUES ('CSS', 'Frontend');
INSERT INTO courses (name, category) VALUES ('React', 'Frontend');
INSERT INTO courses (name, category) VALUES ('Angular', 'Frontend');
INSERT INTO courses (name, category) VALUES ('Vue', 'Frontend');

INSERT INTO courses (name, category) VALUES ('Linux', 'Devops');
INSERT INTO courses (name, category) VALUES ('Docker', 'Devops');
INSERT INTO courses (name, category) VALUES ('Kubernetes', 'Devops');
INSERT INTO courses (name, category) VALUES ('AWS', 'Devops');
INSERT INTO courses (name, category) VALUES ('Azure', 'Devops');