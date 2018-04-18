package com.az.test;

import java.util.*;

public class listcheck {

	public String[][] matchLunches(String[][] lunchMenuPairs, String[][] teamCuisinePreference){

		//check if arguments are null
		if(lunchMenuPairs == null || lunchMenuPairs.length == 0 || teamCuisinePreference == null || teamCuisinePreference.length == 0){
			return null;
		}

		//HashMap of to get items in cuisine from lunchMenuPairs
		HashMap<String,ArrayList<String>> cuisineItems = new HashMap<String,ArrayList<String>>();
		
		//Get All Food List for "*" cases
		ArrayList<String> allFood = new ArrayList<String>();
        
		//prepare HashMap and AllFood
		for(int i=0; i<lunchMenuPairs.length; i++){
			//all food
			allFood.add(lunchMenuPairs[i][0]);
			
			//hash
			if(cuisineItems.containsKey(lunchMenuPairs[i][1])){
				ArrayList<String> listFood = cuisineItems.get(lunchMenuPairs[i][1]);
				listFood.add(lunchMenuPairs[i][0]);				
			}
			else{
				ArrayList<String> listFood = new ArrayList<String>();
				listFood.add(lunchMenuPairs[i][0]);
				cuisineItems.put(lunchMenuPairs[i][1], listFood);
			}
		}
		
		//Create List for each member in teamCuisinePreference
		ArrayList<ArrayList<String>> memberFoodList= new ArrayList<ArrayList<String>>();
		for(int i=0; i<teamCuisinePreference.length; i++){
			String name = teamCuisinePreference[i][0];
			String preference = teamCuisinePreference[i][1];
			
			if(preference.equals("*")){
			  for(String foodItem:allFood){
				  ArrayList<String> pair = new ArrayList<String>();
				  pair.add(name);//name
				  pair.add(foodItem);//value
				  memberFoodList.add(pair);
			  }
			}
			else {
			if(cuisineItems.containsKey(preference)){	
			for(String foodItem: cuisineItems.get(preference)){
				ArrayList<String> pair = new ArrayList<String>();
				pair.add(name);//name
				pair.add(foodItem);//value
				memberFoodList.add(pair);
			}
			}
			else{
				ArrayList<String> pair = new ArrayList<String>();
				pair.add(name);//name
				pair.add("");//value
				memberFoodList.add(pair);
			}
			}
			
		}
		
		//change ArrayList to String[][] return type defined in method
//		String[][] str = new String[memberFoodList.size()][2];
//		for(int i=0; i<memberFoodList.size(); i++){
//			str[i]= memberFoodList.get(i).toArray(new String[2]);
//		}
		String[][] str = memberFoodList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
		//String[][] str = memberFoodList.toArray(new String[memberFoodList.size(new String[2])]);	
	    return str;
	}
}

/*
static Dictionary<String, List<String>> FindTeamFoodPreferences(Dictionary<String, String> lunchMenuPairs, 
    Dictionary<String, String> teamCuisinePreferences)
{
    Dictionary<String, List<String>> teamFoodPreferences = new Dictionary<String, List<String>>();

    if(lunchMenuPairs == null || lunchMenuPairs.Count == 0 || teamCuisinePreferences == null || teamCuisinePreferences.Count == 0)
    {
        Console.WriteLine("Invalid input");
        return default(Dictionary<String, List<String>>);
    }

    Dictionary<String, List<String>> CuisineFoodCombo = new Dictionary<String, List<String>>();

    foreach (KeyValuePair<String, String> foodCuisinePair in lunchMenuPairs)
    {
        List<String> foodList;
        CuisineFoodCombo.TryGetValue(foodCuisinePair.Value, out foodList);
        if (foodList == null)
        {
            foodList = new List<String>();
            foodList.Add(foodCuisinePair.Key);

            CuisineFoodCombo.Add(foodCuisinePair.Value, foodList);
        }
        else
        {
            foodList = CuisineFoodCombo[foodCuisinePair.Value];
            foodList.Add(foodCuisinePair.Key);
        }
    }

    List<String> allFood = new List<String>();
    allFood = lunchMenuPairs.Keys.ToList();


    foreach (KeyValuePair<String, String> cuisine in teamCuisinePreferences)
    {
        if(cuisine.Value == "*")
        {
            teamFoodPreferences.Add(cuisine.Key, allFood);
            continue;
        }

        List<String> foodList;
        CuisineFoodCombo.TryGetValue(cuisine.Value, out foodList);

        teamFoodPreferences.Add(cuisine.Key, foodList);
    }

    return teamFoodPreferences;
}
 */ 