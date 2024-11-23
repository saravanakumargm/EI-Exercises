# **Behavioral Design Patterns**
This folder contains implementations of various behavioral design patterns. Each pattern is demonstrated through different examples, showcasing its application and benefits. 

1. **Chain Of Responsibility - Approval Handling System**
The Chain Of Responsibility Pattern is used to manage approval request in a corporate enviroinment. This pattern allows a chain of handlers to process requests, with each handler passing the request along the chain if it cannot handle it. This implementation includes:

  * **Abstract Handler**: ApproverHandler
  * **Concrete HAndlers**: ManagerHandler, DirectorHandler, VicePresidentHandler
  * **Client**: ChainOfResponsibility.java

This system allows flexible handling of different approval requests and can be easily scaled with additional handlers.

2. **Momento Pattern- Text Editor**
The Memento Pattern is implemented in a text editor example, enabling undo functionality by capturing and restoring the state of the text. The components in the system as follows:

   * **Originator**: TextEditor
   * **Momento**: TextEditorMomento
   * **CareTaker**: EditorHistory
   * **Client**: MomentoPattern.java
This pattern facilitates the management of text states and supports undo operations while encapsulating the text's internal state.

3. **Observer Pattern- Social Media Followers Notification System**:
This Observer Pattern example demonstates a social media followers notification system where the followers receive notification from their subscribed account. The components are as follows:

  * **Observer Interface**: FollwerObserver
  * **Subject**: SocialMedia
  * **Concrete Observer**: Follower
  * **Client**: ObserverPattern.java

This implementation enables real-time notification distribution and management of followers.


