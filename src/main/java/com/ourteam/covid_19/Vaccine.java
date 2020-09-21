package com.ourteam.covid_19;

public class Vaccine {

        private String name;
        private String country;
        private String details;

        public Vaccine(String name, String country, String details) {
            this.name = name;
            this.country = country;
            this.details = details;
        }

        public Vaccine() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

