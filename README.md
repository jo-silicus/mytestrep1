# execmap
Repository for execmap

# Source 
This folder contains eclipse project

# Other
This folder contains 
##  a. Database - DB dump from test instance
##  b. Documents - Design documents
##  c. Running - copy of existing test instance binary setup
###  i. ext-libs - Jars required to build project
###  ii. execmap - complete war folder from test instance
###  iii. server.xml and context.xml from test instance
##  d. Final_Delivery - this is what client has given us (so called deliverables from earlier vendor)


# Developer instructions -
1. Refer source/ folder for instructions on environment setup and eclipse project setup
2. Goal is to first setup replica of test instance on our local env and start debugging the issues
3. Once we have grasp of the system and identify the root issues and fixes, we apply and verify within same env.
4. Post the bug fixes, we will move ahead with upgrades of component versions - Java 1.7+, Tomcat 8.x
5. Database version upgrade is not in scope so we will have to live with it unless we hit a blocker with DB version


