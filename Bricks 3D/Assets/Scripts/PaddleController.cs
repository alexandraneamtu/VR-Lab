using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PaddleController : MonoBehaviour {

	private Rigidbody rb;
	public GameObject LeftWall;
	public GameObject RightWall;
	public GameObject TopWall;
	public GameObject DownWall;
	float moveOrizontal, moveVertical ;
	float speedX=0.2f,speedY=0.2f;


	// Use this for initialization
	void Start () {
		rb = GetComponent<Rigidbody> ();
	}
	
	// Update is called once per frame
	void Update () {
		
	}

	void FixedUpdate() {
		moveOrizontal = Input.GetAxis ("Horizontal");
		moveVertical = Input.GetAxis ("Vertical");



		if ((transform.position.x - transform.localScale.x / 2 <= 
			LeftWall.transform.position.x + LeftWall.transform.localScale.x && moveOrizontal < 0) ||
			(transform.position.x + transform.localScale.x / 2 >=
				RightWall.transform.position.x - RightWall.transform.localScale.x / 2 && moveOrizontal > 0))
		{
			moveOrizontal = 0;
		}

		if ((transform.position.y <= -2.1f &&  moveVertical < 0) ||
			(transform.position.y >= 2.1f && moveVertical > 0))
		{
			moveVertical = 0;
		}

		transform.Translate(new Vector3(moveOrizontal*speedX,moveVertical*speedY,0f));
	}
}
