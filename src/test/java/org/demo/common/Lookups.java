package org.demo.common;


/**
 * Class to store constant values.
 */
public class Lookups {

    /**
     * Enum  for Gender.
     */
    public enum Gender {
        FEMALE {
            public String toString() {
                return "Female";
            }
        },
        MALE {
            public String toString() {
                return "Male";
            }
        },
        UNSPECIFIED {
            public String toString() {
                return "Unspecified";
            }
        },
        NONBINARY {
            public String toString() {
                return "Non-binary";
            }
        },
        DIFFERENTTERM {
            public String toString() {
                return "Different term";
            }
        },
        PREFERNOTTOANSWER {
            public String toString() {
                return "Prefer not to answer";
            }
        }
    }

    /**
     * Chrome options constants.
     */
    public enum ChromeOptions {
        HEADLESS("--headless"),
        DISABLE_NOTIFICATIONS("--disable-notifications"),
        DISABLE_GEOLOCATION("--disable-geolocation"),
        ENABLE_AUTOMATION("--enable-automation"),
        DISABLE_INFOBARS("--disable-infobars"),
        INCOGNITO("--incognito");

        public final String option;


        ChromeOptions(String option) {
            this.option = option;
        }
    }

}
