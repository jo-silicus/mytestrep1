
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
  
