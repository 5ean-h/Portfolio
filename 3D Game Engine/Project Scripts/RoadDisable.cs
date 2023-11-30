using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RoadDisable : MonoBehaviour
{
    
    [SerializeField] GameObject RoadParent;
    private float spawnRate = 6.0f;
    bool isGameActive;

    void Start()
    {
        
        StartCoroutine(SpawnTarget());
    }
    IEnumerator SpawnTarget()
    {
        
        while(true) 
        {
            yield return new WaitForSeconds(spawnRate);
            // Sets bool value to oppisote of what it currently is.
            RoadParent.SetActive(!RoadParent.activeSelf);
        }
    }
}
