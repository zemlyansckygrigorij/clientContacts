-- Table: public.clients

-- DROP TABLE IF EXISTS public.clients;

CREATE TABLE IF NOT EXISTS public.clients
(
    client_id integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT clients_pkey PRIMARY KEY (client_id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.clients
    OWNER to postgres;


-- Table: public.email

-- DROP TABLE IF EXISTS public.email;

CREATE TABLE IF NOT EXISTS public.email
(
    email_id integer NOT NULL,
    email text COLLATE pg_catalog."default" NOT NULL,
    client_id integer NOT NULL,
    CONSTRAINT email_pkey PRIMARY KEY (email_id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.email
    OWNER to postgres;

-- Table: public.phone

-- DROP TABLE IF EXISTS public.phone;

CREATE TABLE IF NOT EXISTS public.phone
(
    phone_id integer NOT NULL,
    phone text COLLATE pg_catalog."default" NOT NULL,
    client_id integer NOT NULL,
    CONSTRAINT phone_pkey PRIMARY KEY (phone_id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.phone
    OWNER to postgres;