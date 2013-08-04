RSS-Mailer
==========

This project started has an idea of sending a motivational quote to my girlfriend and I.
Right now it is modular enough to choose the RSS Feed URL and a cron where you can define the refresh rate.

Major Versions used:

> Spring 3.2.3  
> Rome 1.0.0

Build, Run:

1. mvn clean install
2. mvn jetty:run

## Configuration
- rss.mailer.conf should be placed in conf/ folder of tomcat or .rss.mailer/ in user home.
- Properties are self explanatory just fill the url, refresh rate and mail configurations.
- Righ now you need to configure "from" and "to" inside src/main/webapp/WEB-INF/springMailConfiguration.xml
