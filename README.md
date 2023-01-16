# Spring boot dynamic filter using jackson

It will control your response field in the runtime using below techniques:
    - Add @JsonFilter in the DTO
    - Use 'MappingJacksonValue' class to control which fields are required to be sent back as a response.

- Call Webservice

    curl --location --request GET 'localhost:8080/product/5'
