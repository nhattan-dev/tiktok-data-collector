--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-10-05 10:36:14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 18171)
-- Name: tk_ad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tk_ad (
    ad_id bigint NOT NULL,
    ad_format character varying(255),
    ad_name character varying(255),
    ad_text character varying(255),
    adgroup_id bigint,
    adgroup_name character varying(255),
    advertiser_id bigint,
    app_name character varying(255),
    campaign_id bigint,
    campaign_name character varying(255),
    opt_status character varying(255),
    status character varying(255)
);


ALTER TABLE public.tk_ad OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 18179)
-- Name: tk_adgroup; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tk_adgroup (
    adgroup_id bigint NOT NULL,
    adgroup_name character varying(255),
    advertiser_id bigint,
    age character varying(255),
    campaign_id bigint,
    campaign_name character varying(255),
    create_time character varying(255),
    gender character varying(255),
    languages character varying(255),
    location character varying(255),
    modify_time character varying(255),
    opt_status character varying(255),
    schedule_end_time date,
    schedule_start_time date,
    status character varying(255)
);


ALTER TABLE public.tk_adgroup OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 18187)
-- Name: tk_campaign; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tk_campaign (
    campaign_id bigint NOT NULL,
    advertiser_id bigint,
    bid_type character varying(255),
    budget real,
    budget_mode character varying(255),
    budget_optimize_switch bigint,
    campaign_name character varying(255),
    create_time character varying(255),
    modify_time character varying(255),
    objective character varying(255),
    objective_type character varying(255),
    opt_status character varying(255),
    optimize_goal character varying(255),
    status character varying(255)
);


ALTER TABLE public.tk_campaign OWNER TO postgres;

--
-- TOC entry 2995 (class 0 OID 18171)
-- Dependencies: 200
-- Data for Name: tk_ad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tk_ad (ad_id, ad_format, ad_name, ad_text, adgroup_id, adgroup_name, advertiser_id, app_name, campaign_id, campaign_name, opt_status, status) FROM stdin;
\.


--
-- TOC entry 2996 (class 0 OID 18179)
-- Dependencies: 201
-- Data for Name: tk_adgroup; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tk_adgroup (adgroup_id, adgroup_name, advertiser_id, age, campaign_id, campaign_name, create_time, gender, languages, location, modify_time, opt_status, schedule_end_time, schedule_start_time, status) FROM stdin;
\.


--
-- TOC entry 2997 (class 0 OID 18187)
-- Dependencies: 202
-- Data for Name: tk_campaign; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tk_campaign (campaign_id, advertiser_id, bid_type, budget, budget_mode, budget_optimize_switch, campaign_name, create_time, modify_time, objective, objective_type, opt_status, optimize_goal, status) FROM stdin;
\.


--
-- TOC entry 2860 (class 2606 OID 18178)
-- Name: tk_ad tk_ad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tk_ad
    ADD CONSTRAINT tk_ad_pkey PRIMARY KEY (ad_id);


--
-- TOC entry 2862 (class 2606 OID 18186)
-- Name: tk_adgroup tk_adgroup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tk_adgroup
    ADD CONSTRAINT tk_adgroup_pkey PRIMARY KEY (adgroup_id);


--
-- TOC entry 2864 (class 2606 OID 18194)
-- Name: tk_campaign tk_campaign_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tk_campaign
    ADD CONSTRAINT tk_campaign_pkey PRIMARY KEY (campaign_id);


-- Completed on 2021-10-05 10:36:14

--
-- PostgreSQL database dump complete
--

