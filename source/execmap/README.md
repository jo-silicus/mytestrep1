
# Overview
The existing app is running on AWS cloud with old versions of tools/frameworks.
Since the codebase is written for old versions of Java(1.3) and Tomcat(5.5) we also need to setup accordingly instead of latest versions.
Once the basic setup is done and we have a running system, we can start debugging/fixing the issues and upgrading parts of system one by one.

# Initial setup - 
1. Install Java 1.5 (The production setup of this app runs on Java 1.5)
2. Install Tomcat 5.5.
3. Install Eclipse Ganymede.
4. Install SQL Server 2005(this is what Production version has)/SQL Express.
5. Import into your SQL server installation, existing db dump from other\Database\execmap-tes-db.zip. This is a dump from test setup.
6. Note that SQL Server 2005 may not work properly on new machines. In that case we need to try out new version of SQL server express and import old data. It is still not known if even the old data import will work on new version. Needs bit of R&D.

# Eclipse Project setup -
1. Import the project into workspace (Import->General->Existing Projects)
2. Go to Project Build properties and set the libraries as follows
  a. Checkout the libraries from execmap\other\Running\ext-libs directory of this repo.
  b. Add all the jars from above path to build path.
3. Open build.xml and read comments at the top for properties that need to change.
4. You will need to checkout few other libraries from /other/Running/execmap folder to make it work.
5. 

# Information on Project architecture -
1. There are admin and assessment sections of the product that work based on logged in user type. 
2. Project is built on Struts, Hibernate, Tiles, Spring.
3. There are i18n elements which are crucial for us to understand considering the bugs are related to languages.
4. The UI layer is also important to understand since we are going to work on making it responsive. Knowing the way tiles and struts work together to create different pages based on various layouts will help us.
5. There are parts of reporting which uses PDF/Word/Html report generation. We may need to work on this layer at a later stage for minor enhancements.
6. The DB layer is not supposed to be touched considering we are not changing any business logic.
7. The language support can be added using a language.properties file. Refer to other/Final_Delivery/ for User manual.
8. As of now only English is supported and other languages do not work as expected. We need to find a way out to support them.
9. The branding portion works by only adding logo/images via admin portal
  
