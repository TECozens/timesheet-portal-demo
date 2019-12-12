package com.admiral.tsp.timesheetportal.architecture;

import com.structurizr.Workspace;
import com.structurizr.analysis.ComponentFinder;
import com.structurizr.analysis.ReferencedTypesSupportingTypesStrategy;
import com.structurizr.analysis.SourceCodeComponentFinderStrategy;
import com.structurizr.analysis.SpringComponentFinderStrategy;
import com.structurizr.api.StructurizrClient;
import com.structurizr.documentation.Format;
import com.structurizr.documentation.StructurizrDocumentationTemplate;
import com.structurizr.model.*;
import com.structurizr.view.*;
import org.junit.jupiter.api.Test;

import java.io.File;

public class generateModel {


    @Test
    public void generateModel() throws Exception {


        File sourceRoot = new File("c:/Users/C1887859/Desktop/Year 2/Semester 2/Commercial Applications with Java/Assessment 2/ase-tsp-client-project");

        Workspace workspace = new Workspace("Time Sheet Portal", "Assessment 2: Client Project");
        Model model = workspace.getModel();
        ViewSet viewSet = workspace.getViews();


        // create the context diagram

        //create our system
        SoftwareSystem timesheetPortal = model.addSoftwareSystem("timesheetportal", "Online Time Sheet Portal");
        //add personas
        Person admin = model.addPerson("Admin.", "A person who is in charge of the system");
        Person manager = model.addPerson("Manager",  "A person who manages contractors");
        Person contractor = model.addPerson("Contractor.", "A person who is a contractor in the system");
        //define usages
        admin.uses(timesheetPortal, "Uses");
        manager.uses(timesheetPortal, "Uses");
        contractor.uses(timesheetPortal, "Uses");
        //create external dependencies
        SoftwareSystem timesheet = model.addSoftwareSystem("TimeSheet", "Time Sheet to send to managers");
        SoftwareSystem confirmationToken = model.addSoftwareSystem("ConfirmationToken", "Token to reset password");
        SoftwareSystem review = model.addSoftwareSystem("Review","Reviewing time sheet of approved time sheet");
        //define external usages
        timesheetPortal.uses(timesheet, "sends timesheets", "SOAP");
        timesheetPortal.uses(confirmationToken, "sends token requests", "HTTPS");
        timesheetPortal.uses(review,"sends time sheet approval review","SOAP");
        //create the view
        SystemContextView contextView = viewSet.createSystemContextView(timesheetPortal, "context", "The System Context diagram for the Time Sheet Portal system.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
        contextView.setAutomaticLayout(true);


        //create the container diagram
        Container webApplication = timesheetPortal.addContainer(
                "Spring Boot Application", "The web application", "Embedded web container.  Tomcat 7.0");
        Container relationalDatabase = timesheetPortal.addContainer(
                "Relational Database", "Stores information regarding the timesheet and their targets.", "MySQL");
        admin.uses(webApplication, "Uses", "HTTP");
        manager.uses(webApplication, "Uses", "HTTP");
        contractor.uses(webApplication, "Uses", "HTTP");
        webApplication.uses(relationalDatabase, "Reads from and writes to", "JPA, port 3306");
        //create the view
        ContainerView containerView = viewSet.createContainerView(timesheetPortal, "containers", "The Containers diagram for the Time Sheet Portal system.");
        containerView.addAllContainers();
        containerView.setAutomaticLayout(true);

        SpringComponentFinderStrategy springComponentFinderStrategy = new SpringComponentFinderStrategy(new ReferencedTypesSupportingTypesStrategy(true));
        springComponentFinderStrategy.setIncludePublicTypesOnly(false);

        System.out.println("Let's scan for components");


        // and now automatically find all Spring @Controller, @Component, @Service and @Repository components
        ComponentFinder componentFinder = new ComponentFinder(
                webApplication,
                "com.admiral.tsp.timesheetportal", //change for your package structure
                springComponentFinderStrategy
                , new SourceCodeComponentFinderStrategy(new File(sourceRoot, "/src/main/java/"), 150)

        );

        try {
            componentFinder.findComponents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Let's see what is being scanned

        System.out.println("Component List");
        System.out.println("--------------");

        for (Component c : webApplication.getComponents()) {
            System.out.println(c);
        }

        System.out.println("Relationships");
        System.out.println("--------------");

        for (Component c : webApplication.getComponents()) {
            System.out.println(c.getRelationships());
        }

        // connect the donor to all of the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> admin.uses(c, "Uses", "HTTP"));

        // connect the participant to all of the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> manager.uses(c, "Uses", "HTTP"));

        // connect the trustee to all of the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> contractor.uses(c, "Uses", "HTTP"));

        // connect all of the repository components to the relational database
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY))
                .forEach(c -> c.uses(relationalDatabase, "Reads from and writes to", "JPA"));


        //link internal components

        Component cservice = webApplication.getComponentOfType("com.nsa.cm6213.charity2019walk.service.CharityFinder");
        cservice.addTags("contrib: Carl, Simon");

        System.out.println("charity service = " + cservice);

        Component cRepo = webApplication.getComponentOfType("com.nsa.cm6213.charity2019walk.data.JpaCharityRepository");

        System.out.println("charity repo = " + cRepo);

        cservice.uses(cRepo, "uses");

        //what about templates?

        Component charityProfilePage = webApplication.addComponent("t_charity_profile_page.html", "Charity Profile Page", "Thymeleaf");
        System.out.println(charityProfilePage);

        Component charityController = webApplication.getComponentOfType("com.nsa.cm6213.charity2019walk.web.CharityProfileController");
        System.out.println(charityController);

        charityProfilePage.uses(charityController, "is fed data by");

        //what about configuration e.g. security

        Component securityConfig = webApplication.addComponent("SecurityConfiguration", "Determines the security process", "Spring Security");
        Component userDetailsService = webApplication.addComponent("UserDetailsService", "Provides the User authentication and authorisation data", SpringComponentFinderStrategy.SPRING_SERVICE);
        securityConfig.uses(userDetailsService, "delegates user retrieval to");

        // Create the component view and add all components (and the database for reference).

        ComponentView componentView = viewSet.createComponentView(webApplication, "components", "The Components diagram for the Charity 2018 web application.");
        componentView.addAllComponents();
        //componentView.addAllPeople(); //could show all users using controllers.
        componentView.add(relationalDatabase);
        componentView.setAutomaticLayout(true);

        // link the architecture model with the code
        for (Component component : webApplication.getComponents()) {
            for (CodeElement codeElement : component.getCode()) {
                String sourcePath = codeElement.getUrl();
                if (sourcePath != null) {
                    codeElement.setUrl(
                            "https://gitlab.cs.cf.ac.uk/CM6213-Commercial-Applications-with-Java/cm6213-1920/charity-walkthrough/tree/master");
                }
            }
        }

        // tag and style some elements
        timesheetPortal.addTags("Charity Giving 2019");
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(c -> c.addTags("Spring MVC Controller"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REST_CONTROLLER)).forEach(c -> c.addTags("Spring REST Controller"));

        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_SERVICE)).forEach(c -> c.addTags("Spring Service"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY)).forEach(c -> c.addTags("Spring Repository"));
        relationalDatabase.addTags("Database");


        Styles styles = viewSet.getConfiguration().getStyles();
        styles.addElementStyle("Charity Giving 2019").background("#6CB33E").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#519823").color("#ffffff").shape(Shape.Person);
        styles.addElementStyle(Tags.CONTAINER).background("#91D366").color("#ffffff");
        styles.addElementStyle("Database").shape(Shape.Cylinder);

        styles.addElementStyle("Spring REST Controller").background("#C0FFd4").color("#000000");

        styles.addElementStyle("Spring MVC Controller").background("#D4F3C0").color("#000000");
        styles.addElementStyle("Spring Service").background("#6CB33E").color("#000000");
        styles.addElementStyle("Spring Repository").background("#95D46C").color("#000000");

        // add some documentation
        StructurizrDocumentationTemplate template = new StructurizrDocumentationTemplate(workspace);
        template.addContextSection(timesheetPortal, Format.Markdown,
                "This is a simple charity donation system based on JustGiving to illustrate Spring Boot...\n" +
                        "\n" +
                        "![](embed:context)");

        System.out.println("Contacting Structurizr");

        System.out.println("USE YOUR OWN KEYS FOR YOUR PROJECTS.");

        StructurizrClient structurizrClient = new StructurizrClient("de6c3403-ae8a-4ac2-9b13-5fb2775a6d2d", "3ae12234-3351-4783-ad88-bd624f9f3cc4");

        try {
            structurizrClient.putWorkspace(41640, workspace);
            System.out.println("Uploaded");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
