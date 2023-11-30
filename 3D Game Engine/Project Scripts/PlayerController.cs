using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class PlayerController : MonoBehaviour
{
    [SerializeField] GameObject Trail1;
    [SerializeField] GameObject Trail2;
    private float speed = 0;
    private float MaxSpeed = 35;
    private float turnSpeed = 10;
    private float horizontalInput;
    private float forwardInput;
    private int score;
    public TextMeshProUGUI scoreText;
    private Vector3 movement;
    public float Drag = 0.98f;
    public float Traction = 1;

    public bool isGameActive; 
    public Button startButton;
    public GameObject titleScreen;
    public GameObject finishScreen;
    public Button nextButton;
    

    public ParticleSystem explosionParticle;
    
    public bool isThree=false;


    // Start is called before the first frame update
    void Start()
    {
        
        Button btn = startButton.GetComponent<Button>();
        btn.onClick.AddListener(Menu);

        Button nxt = nextButton.GetComponent<Button>();
        nxt.onClick.AddListener(loadLevel1);

    }
    // Update is called once per frame
    void Update()
    {   
        

        //while(isGameActive)
        //{        
            //Move vehicle forward/back         
            movement += transform.forward * Time.deltaTime * speed * Input.GetAxis("Vertical");
            transform.position += movement * Time.deltaTime;

            //Move turn the vehicle
            horizontalInput = Input.GetAxis("Horizontal");
            transform.Rotate(Vector3.up * turnSpeed * movement.magnitude * horizontalInput * Time.deltaTime);

            //Drag
            movement *= Drag;
            movement = Vector3.ClampMagnitude(movement, MaxSpeed);

            //Traction
            movement = Vector3.Lerp(movement.normalized, transform.forward, Traction * Time.deltaTime) * movement.magnitude;

            if (transform.position.y < -10) // where -10 is the lowest the player can fall before reset
            {
                Respawn();
            }
        //}

    }
    void OnTriggerEnter(Collider other) 
	{
		// ..and if the GameObject you intersect has the tag 'Pick Up' assigned to it..
		if (other.gameObject.CompareTag("PickUp"))
		{
			other.gameObject.SetActive (false);
            UpdateScore();
		}

        if (other.gameObject.CompareTag("Barrel"))
		{
			other.gameObject.SetActive (false);
            Respawn();
            Instantiate(explosionParticle, other.gameObject.transform.position, explosionParticle.transform.rotation);
		}

        if (other.gameObject.CompareTag("Finish"))
		{
            
            other.gameObject.SetActive(false);
            nextLevel();
            
            
            Instantiate(explosionParticle, gameObject.transform.position, explosionParticle.transform.rotation);
        }
	}
    void Respawn()
    {
        transform.position = new Vector3(0,0,0);  
        GetComponent<Rigidbody>().velocity = Vector3.zero;
        transform.eulerAngles = new Vector3(0,0,0);
        movement = new Vector3(0,0,0);
    }
    void UpdateScore()
    {
        score += 5;
        scoreText.text = "Score: " + score;
    }
    public void Menu()
    {
        //isGameActive = true;
        speed = 50;
        startButton.gameObject.SetActive(false);
        titleScreen.gameObject.SetActive(false);
    }
    public void nextLevel()
    {
        speed = 0;
        finishScreen.gameObject.SetActive(true);

        if(SceneManager.GetActiveScene().name == "Level1")
        {
            nextButton.gameObject.SetActive(true);
        }
    }
    public void loadLevel1()
    {
      SceneManager.LoadScene(1);  
    }
    
}
