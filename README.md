# assembla-api

Java wrapper around Assembla API

## Introduction

This project provides a Java wrapper around the Assembla API. It aims to support
all Assembla API endpoints, excluding 'Portfolio' endpoints.

Assembla API documentation can be found [here](https://api-doc.assembla.com/content/api_reference.html).

Supports Java 8, does not support older versions of Java.

## Support status

| Type                           | Supported |
|--------------------------------|-----------|
| Activity                       | Yes       | 
| Mentions                       | Yes       |
| Users                          | Partial   |
| Spaces                         | Yes       |
| User Roles (Space members)     | Yes       |
| Space tools                    | Yes       | 
| Tickets                        | Yes       |
| Ticket statuses                | Yes       |
| Tags                           | Yes       |
| Tickets custom fields          | Yes       |
| Ticket Associations            | Yes       |
| Ticket Comments                | Yes       |
| Milestones                     | Yes       |
| Documents                      | Partial   |
| StandUp Reports                | Yes       |
| StandUp Away Reports           | Yes       |
| Merge Requests                 | Yes       |
| Merge Request Versions         | Yes       |
| Merge Request Version Comments | Yes       |
| Merge Request Version Votes    | Yes       |
| Wiki Pages                     | Yes       | 
| Wiki Page Versions             | Yes       |
| Webhooks                       | Yes       |
| Tasks                          | Yes       |
| User SSH keys                  | Yes       |
| Space SSH Keys                 | Yes       |
| SSH Servers                    | Yes       |
| SSH Actions                    | Yes       |
| SSH Action Launches            | Yes       |


## Obtaining Access Key
Assembla uses Oauth2 to authenticate API requests. To use this API
an API Key and API Secret Key are required. Visit Assembla's authentication
information [page](https://api-doc.assembla.com/content/authentication.html#key_secret_credentials) to learn how to generate these.

## Usage
#### Getting started 

The root entry point for Assembla's API is through the `AssemblaAPI` class 
```java
//Create a new AssemblaAPI 
AssemblaAPI api  = AssemblaAPI.create("your API key", "your API secret key");        
```
The `AssemblaAPI` class provides access to each of the Assembla end points documented at [here](https://api-doc.assembla.com/content/api_reference.html). 

#### Accessing ticket end points

Return a ticket by number associated with space "example_space".
```java 
//Getting a ticket by number
Ticket ticket100  = api.tickets("example_space").getByNumber(100);
```
Return a `List` of all active tickets associated with space "example_space"
```java
//Getting all active tickets
List<Ticket> activeTickets = api.tickets("example_space").getActive();

