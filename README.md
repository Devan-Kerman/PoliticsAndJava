# PoliticsAndJava
A Simple Politics and War API wrapper for Java<br/>
## This is a library bent on distancing the user from the raw api<br/>
  #### 1. Consistant - trying to make it easier on the eyes and logic<br/>
    - Consistant naming, similar variable names for things that represent the same thing (alex does this fairly well already though)
    - Consistant typing, the current api is ok. it's consistant... consistantly bad LOL GOTEM jk no kill plz
  #### 2. Documented - am yet to fully do this though<br/>
  #### 3. Correct - the main focus of the library, Alex's types are quite jank, "1" and "0" as booleans, doubles in strings, etc.<br/>
      - Date objects rather than strings
      - Lots, and lots, of enums :)
      - booleans rather than strings ("1" and "0")
      - floats/doubles rather than strings ("12.4534")
      - fixing other oddities in the api
      - uses Gson, and by extention can handle the occassional malformed json that is given<br/>
  #### 4. Fast - although this layer of type correction does add a delay, it's not significant built in caching is an important part of the library<br/>
      - This type correction layer does add a noticable delay, but your actual code will end up running faster, for example, string comparison is much slower than floats and enums.
  #### 5. Diverse - will probably copy paste some parts of my old wrapper into this one, such as webscraping and other utilities.<br/>
  #### 6. Easy to use - throwing somewhat usefull exceptions, well, that's what it attempts atleast.<br/>
## This library also includes tons and tons of other epic utilities
    - Message automation
    - Other web automations
    - Web scraping
    - Hooks
