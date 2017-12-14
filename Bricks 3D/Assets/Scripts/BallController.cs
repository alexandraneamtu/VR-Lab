using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallController : MonoBehaviour {

	private Rigidbody rb;
	private bool inPlay = false;
	//private float initialVelocity=7f;

	// Use this for initialization
	void Start () {
		rb = GetComponent<Rigidbody> ();

	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetKeyDown ("space") && inPlay == false) {
			rb.velocity = new Vector3(Mathf.Sign(Random.Range(-1f, 1f)) * 5f, Mathf.Sign(Random.Range(-1f, 1f)) * 4f, 7f);
			inPlay = true;
		}

		if (Input.GetKeyDown ("a") && inPlay == true) {
			rb.velocity *= 2f;
		}
	}


	void FixedUpdate(){
		if (transform.position.z < -7.2f) {
			transform.position = Vector3.zero;
			rb.velocity = Vector3.zero;
			inPlay = false;
		}

		else 
			if (Mathf.Abs(rb.velocity.z) < 5f && inPlay == true)
				rb.velocity = new Vector3(rb.velocity.x, rb.velocity.y, rb.velocity.z * 2f);
	}


	void OnTriggerEnter(Collider other){
		if(other.gameObject.CompareTag("Brick")) {
			rb.velocity = new Vector3(Mathf.Sign(Random.Range(-1f, 1f)) * 5f, Mathf.Sign(Random.Range(-1f, 1f)) * 4f, rb.velocity.z);
			other.gameObject.SetActive (false);
		}

		if (other.gameObject.CompareTag ("Paddle")) {
			rb.velocity = new Vector3 (Mathf.Sign (Random.Range (-1f, 1f)) * rb.velocity.x, Mathf.Sign (Random.Range (-1f, 1f)) * rb.velocity.y, rb.velocity.z);
		}
	}

		
}
