# COMP2042_CW_hcyyh1

#Refactoring
<b>1. Organise classes into packages and use meaningful naming</b></br>
Classes are separated into 4 packages, namely controller, model, view and game so that they are more organised.

<b>2. Basic maintenance</b></br>
i. Rename variables and method names</br>
-Correct spelling mistakes (e.g. MoveRight, borderStroke, etc).</br>
-Meaningful naming (e.g. BACKGROUND_COLOR, innerColor etc).</br>
-Suitable naming (e.g. menuButton to exitButton etc).</br>
ii. Encapsulation</br>
Add “private” and “protected” access modifiers to some variables 
and use public getter and setter methods to get or set the values 
of the variables to achieve encapsulation (e.g. private Point2D up, 
protected Shape brickFace and their respective getters and setters, etc).</br>
iii. Deleting unused resources </br>
-Variables (e.g. CRACK_SECTIONS, MIN_CRACK etc).</br>
-Methods (e.g. inMiddle and jumps method in Crack class).</br>

<b>3. Design patterns</b></br>
i. Factory design pattern</br>
-BrickFactory is used to create different types of Brick objects.</br>
-BallFactory is used to create different types of Ball objects.</br>
ii. MVC</br>
Use MVC design patterns for GameBoard, HomeMenu and InfoPage class and 
VC for HighScore class.</br>
View class will render the view.</br>
Model class consists of dumb entities (POJO). </br>
Controller class is in charge of changing the Models’ state and notify the View. </br>
Listeners are inside View class. When the listeners capture event, they pass the events to Controller class to handle action.</br>

<b>4. Meaningful Junit tests</b></br>
I tried my best to write Junit tests to cover as much testing as possible. 
For some methods, I even use different tests to ensure there are no bug. </br>

<b>5. Use of build tool</b></br>
I converted Java project to Maven project. </br>
Junit dependency is also added in pom.xml.</br>

<b>6. SOLID principles (Single responsibility) </b></br>
i. I separated Crack class from Brick class as Crack class is 
responsible for making crack on bricks whereas Brick class 
defines characteristic of bricks.</br>
ii. I created a new Level class by extracting it out from Wall 
class as Level class is responsible for making levels while Wall 
class handles most of the things happen to the wall. </br>

<b>7. Others</b></br>
i. Fix initial speed of ball to enhance user experience.</br>
ii. Show speed of ball on sliders to enhance user experience and let user plan their strategy of winning.</br>
iii. Correct wrong logic (impactWall method) where crack will not be made when ball hits the brick on the left/right side.</br>

#Additions
<b>1. Permanent high score list</b></br>
-Store the highest score and name of the record holder is in .dat file.</br>
-Prompt for user’s name when higher score is made.</br>

<b>2. High score screen</b></br>
-Display current score, the highest score and name of the record holder.</br>
-Quit game button to let user exit the game.</br>

<b>3. Additional levels</b></br>
FastBrick will make the ball moves faster while SlowBrick will 
make the ball moves slower when the ball hits the brick. </br>

<b>4. Give reward/penalty to player</b></br>
i. Timer</br>
ii. Audio </br>
iii. Special brick to reduce the time taken to play the game by 60 seconds </br>

<b>5. Anything simple feature</b></br>
i. Add background image to START screen </br>
ii. Add INFO button </br>
iii. Add INFO screen </br>
iii. Add logo of game </br>

#Acknowledgment
The original code is obtained from https://github.com/FilippoRanza/Brick_Destroy






