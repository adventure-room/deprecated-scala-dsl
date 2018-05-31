class EventMapping extends EventMappingEnglish {

  button("b5") --> (StartTest, Map("testArgument" -> "testValue"))

  button("b5") --> SimpleTest

}
