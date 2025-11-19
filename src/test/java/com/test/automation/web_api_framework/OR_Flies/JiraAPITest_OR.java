package com.test.automation.web_api_framework.OR_Flies;

public class JiraAPITest_OR {
	public static final String APIEncodedToken="Basic eWFzZXJhcmFmYXRoMjIxMEBnbWFpbC5jb206QVRBVFQzeEZmR0YwcERwSWJGcndxQnRfblladEtoc3c2LW93d1c2Rjg0c2VwVDZpQ1NvSU9QOEw2ZFpsbVU5dUx4QXBJWEVRSmphZHBTTUgzODRLVmtNbXNtUE1sV3hTUHY0eWFfTWp6c0o0NXM5WEk5eVBMeXN4TEdoTGpFY2hyR2dwY25wVkdDVkltemVNS29kSlRzVzJvWS1QaUM4YmJuNHh2U2NvWldVRjIyX2pqSlVaWmlNPUU1Q0VGQzRC";
	public static final String baseURI="https://yaserarafath2210-1763536223359.atlassian.net/";
	
		public static String body="{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"SCRUM\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"Test from postman to create bug\",\r\n"
				+ "        \"description\": {\r\n"
				+ "            \"type\": \"doc\",\r\n"
				+ "            \"version\": 1,\r\n"
				+ "            \"content\": [\r\n"
				+ "                {\r\n"
				+ "                    \"type\": \"paragraph\",\r\n"
				+ "                    \"content\": [\r\n"
				+ "                        {\r\n"
				+ "                            \"type\": \"text\",\r\n"
				+ "                            \"text\": \"Creating an issue from postman using Jira API\"\r\n"
				+ "                        }\r\n"
				+ "                    ]\r\n"
				+ "                }\r\n"
				+ "            ]\r\n"
				+ "        },\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
		
	
}
