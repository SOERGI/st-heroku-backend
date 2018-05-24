--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 10.3

-- Started on 2018-05-21 16:06:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 16412)
-- Name: stherokubackend_dev; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA stherokubackend_dev;


ALTER SCHEMA stherokubackend_dev OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16413)
-- Name: profile; Type: TABLE; Schema: stherokubackend_dev; Owner: postgres
--

CREATE TABLE stherokubackend_dev.profile (
    "businessName" character varying,
    "businessLocation" character varying,
    id integer NOT NULL,
    "businessCategory" character varying,
    "businessImage" character varying
);


ALTER TABLE stherokubackend_dev.profile OWNER TO postgres;

--
-- TOC entry 2801 (class 0 OID 16413)
-- Dependencies: 199
-- Data for Name: profile; Type: TABLE DATA; Schema: stherokubackend_dev; Owner: postgres
--

COPY stherokubackend_dev.profile ("businessName", "businessLocation", id, "businessCategory", "businessImage") FROM stdin;
\.


--
-- TOC entry 2679 (class 2606 OID 16420)
-- Name: profile profile_pkey; Type: CONSTRAINT; Schema: stherokubackend_dev; Owner: postgres
--

ALTER TABLE ONLY stherokubackend_dev.profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (id);


-- Completed on 2018-05-21 16:06:05

--
-- PostgreSQL database dump complete
--

