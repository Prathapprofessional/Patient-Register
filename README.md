# Application task

Thank you for applying to our job offering.
In the following are a bunch of tasks which could appear in a similar kind in your upcoming workload.
The first part contains general questions.
Please answer the questions after forking this repo and keep it private.
The second part asks for a common git scenarios.
The third part requires implementation tasks.

## Part 1: Questions

Please answer the following quesitons shortly inside this file.

### Why is health data such as this especially protected by the data protection and privacy regulations?

- The health data should be protected for the following reasons,
- #### 1.Regulations:
-  GDPR regulation and BDSG protection act governs the way how the sensitive health data are being handled.
- #### 2. Sensitive data :
- These health information are very sensitive personal data so it can be misused to cause harm personally or even
  discriminate during insurance coverage or during employment.
- #### 3. Consent:
- Health data for example here the biopsy results can be processed with vivid consent by the patient.
- #### 4. Minimization and Security:
- Only necessary data should be procured and stored.
- Secured encryption and access controls should be handled well to avoid unauthorised access which might lead to leakage of
  personal health data. Trust opf the patient is broken
-  #### 5. Legal risks:
- Fines may be imposed along with legal risks

So for a software developer it is very essential to abide all the rules and regulations of the field of work before venturing
into it.

### How do you provide animation logic in Unity-based game?

- In unity, we can provide animation via two ways either Animator component or Animator Controller.
- Animator controller are created and then can be triggered using C# scripts.
- External tools like Blender or Maya can be used to import animations
- Simple terms in Unity-->Animation window --> GameObject(Character) and then new animation clip is ready!
- Unity --> Assets folder --> right click --> Create--> Animator Controller . We can also attach this to the Animator Component of the GameObject. We can
  define animation states ("Idle",""Run" , "Jump") and the transitions.
  let's say with an example,
- say a float called Speed controls the transition between states
- Speed > 0.1 means from Idle to Run
- Speed <=0.1 means from Run to Idle

public class Player: MonoBehaviour
{
private Animator animator;
private float moveInput;

    void Start()
    { 
      animator = GetComponent<Animator>();
      }
    Void Update()
    {
      moveInput= Input.GetAxis("Horizontal"); // Arrowkeys or WASD input
      animator.SetFloat("Speed", Mathf.Abs(moveinput);

     }

}

### Please explain how file permissions work in Linux. What different kinds of permissions are there? How are they assigned to a file or directory?


In linux there three types of users,
- #### 1. Owner
File Creator.
- #### 2. Group
Group of users which have same set of permissions.
- #### 3. Others
Every other users.

And then there are three types of permissions
- #### 1. Read(r) :
Users can view the content of the file or listing a directory's contents.
- #### 2. Write(w) :
Allows the users to modify the file or removing/ adding the files to a directory.
- #### 3.Execute(x) :
  Allows executing or running the file as a program or entering inside a directory.

#### Assigning permissions :
1.Numeric Mode Numbers are used to mark the permissions , write is 2 , Read is 4 and Execute is 1
so chmod 755 file.txt means Owner: Read/Write/Execute , Group : Read/Execute and Others : Read/Execute
1.Symbolic way chmod u+x file.txt    this means adding execute permission to the owner.

in Order to change the ownership :
Ex: chown user:group file.txt this sets user as the Owner and Group as Group
#### Directory permissions :
Read : shows or lists the directory contents.
Write: Create, rename or delete the files inside the directory.
Execute: Enters into the directory (cd command)


## Part 2: Git skills

Git is a common tool to keep track of code development and collaborative programming.
Before continuing please commit your answers so far, thanks.

### Git merge

If you check the branches of this repository you will recognize another branch.
Please merge the branch and its containing files into your main branch.
Resolve possible merge conflicts.


## Part 3: Simple demo app

### Implementation task

Create an android app which allows the user to register a patient with firstname, lastname, date of birth, weight, shoesize.
Additionally the app should instruct the user to take four pictures of the patients feet, the top and bottom per foot.
The backend can be mocked and does not have to be implemented by you. However, it should ideally be a REST API endpoint.

### What privacy issues are related to this feature?

- In this feature the privacy issues to be noted are,
- 1. Personalised photos of patients are being used which is sensitive, 
might lead to identification of feet and can cause privacy concerns.
- 2. Name,DOB,Weight are personal information which are being captured here so there should not be any leakage or 
unauthorised access of these data. Might cause legal tensions.
- 3. If these sensitive data is stored in database or cloud, it should be encrypted and access should be very secure.
- 4. Here backend is mocked so the data sharing part should be  done with user concerns and secured way. Also there
should be transparency in usage or processing of these consented data.
- 5. All regulations of GDPR and BDSG should be abided as mentioned previously.

After completing the tasks please send us an invite to your forked repository (Nikolajewitsch, istiyaksiddiquee ).

