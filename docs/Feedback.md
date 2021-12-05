# Feedback
#### by Ivan Poluboiarynov
___

| Project effectively utililizes the technologies and technques specified in the project objectives |
|---|

| Areas for Improvement | Criteria | Items Met or Exceeded |
|:---------------------:|----------|:---------------------:|
|  | Planned MVP Functionality | The functionality declared in the readme document is sufficient for the initial use of the product with the possibility of further expanding the functionality. |
|  | Logging framework used, i.e., no System.out.println() or printStacktrace() statements. | To log errors, the necessary dependencies are connected and the properties file is installed with the necessary logging configuration settings. |
|  | Hibernate used for all data access. | Yes. Hibernate is connected to the project through the appropriate dependencies and is used for all data |
| The authentication functionality is currently incomplete. | Authentication implemented. | Yes. I can see the controllers for authentication and login, and I can also see the file folder for working with aws cognito authentication, token generation and validation. |
| At the moment, the use of an external API is under development. | Consumes at least one web service or public api using Java. | I assume that the API will be used to search for geolocation, which is very awesome |
| So far, there is no way to check the efficiency of the methods. | Application is database-driven using full CRUD. | The project uses the GenericDao pattern to recreate all typical CRUD operations on objects. |
|  | Database includes multiple one to many relationships. | Absolutely. Almost every table is related to others with a OneToMany or ManyToOne relationship. |
| In Progress | Deployed to AWS for public access. |  |
|  | Implements best practices (for example, data validation) |  |

| Synthesis of multiple concepts in unfamiliar situations requiring research beyond the scope of the class |
|---|

| Areas for Improvement | Criteria | Items Met or Exceeded |
|:---------------------:|----------|:---------------------:|
|  | Experiments individually, exhibits independence and drive, shows originality in the solution. | Yes. I noticed the validation js file, which is curious |
| Most of the code is used within the learned course. | Implemented technologies or techniques not covered in course materials. |  |

| Code quality - Evaluate code quality for the following and identify specific areas for improvement (class, method or line number). Be sure to list which code quality plugins/tools you used to assist with this analysis |
|---|

| Areas for Improvement | Criteria | Items Met or Exceeded |
|:---------------------:|----------|:---------------------:|
|  | Single-purpose methods | Yes, each method encapsulates a single task |
|  | Well-structured project | The structure of the project follows the norms that we learned in the Java courses. |
|  | Descriptive naming of packages, classes, methods, variables | All names of classes and methods clearly describe their purpose. |
|  | Classes appropriately-sized (no monster classes) | I have not found too long functions |
|  | CPD (copy paste detection, meaning are the same lines of code repeated? | I have found several cases. In my opinion, it is not critical. |
| A little | Are there candidates for super/subclass relationships, abstract classes, interfaces |  |
|  | Proper exception handling | Yes. The project involves catching exceptions |
| In Progress | Proper error reporting to the user - custom error pages? |  |
|  | Code documentation | Yes |
|  | Is there code in the servlet doGet/doPost that should be refactored into testable classes or methods? |  |
| Pages are unfinished for evaluation | Evaluate the JSPs for templating, data validation, overall look and feel. |  |
|  | JSPs use JSTL and EL, no java code | Yes. JSP pages uses different types of EL |
|  | Unit tests are truly a unit test rather than a high level functional test | Yes unit tests meet the requirements |
|  | Test data is appropriately cleaned up or handled | All tests run against a separate database |
| In Progress | There is full coverage of methods that perform business logic or utility functions |  |
|  | Redundant code is eliminated by using set up and tear down methods, i.e., @Before, @After | not found |

### Other comments/notes?

| Areas for Improvement | Criteria | Items Met or Exceeded |
|:---------------------:|----------|:---------------------:
|  | Demonstrates initiative and thoughtful planning to leverage available resources (time, equipment, external expertise) to meet milestones and project objectives. | It's hard for me to appreciate it |
|  | Evidence of significant revision and incorporation of feedback. |  |
|  | Project complexity | The project is complex enough for initial development |
|  | Additional Comments | At the time of the code review, some components of the project are under development, so I only evaluated what is ready now. And I hope the project will turn out great. |