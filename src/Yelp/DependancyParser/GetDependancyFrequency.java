package Yelp.DependancyParser;

import static Yelp.DependancyParser.Featureselection.ambianceF;
import static Yelp.DependancyParser.Featureselection.foodF;
import static Yelp.DependancyParser.Featureselection.worthinessF;
import static Yelp.DependancyParser.Featureselection.restaurantF;
import static Yelp.DependancyParser.Featureselection.priceF;
import static Yelp.DependancyParser.Featureselection.serviceF;

public class GetDependancyFrequency {

    public static int FoodFrequency(String Toekns) {
        int mastercount = 0;
        int startpoint=0;
        try {
            StringBuilder sb = new StringBuilder();

            for ( startpoint = 0; startpoint < foodF.size()-1; startpoint++) {
                String[] foodparts = foodF.get(startpoint).toString().split("#");
                String[] LemmasTokens = foodparts[1].split(",");
                if (LemmasTokens.length > 0) {
                    for (int first = 0; first < LemmasTokens.length; first++) {
                        String currentFeature = LemmasTokens[first];
                         if (currentFeature.equalsIgnoreCase(Toekns)) {
                            mastercount = mastercount + 1;
                        }
                    }
                }
            }
        } catch (Exception e) {
            
        }
        return mastercount;
    }

    public static int PriceFrequency(String Toekns) {
        int mastercount = 0;
        StringBuilder sb = new StringBuilder();
        for (int startpoint = 0; startpoint < priceF.size(); startpoint++) {
            String[] priceparts = priceF.get(startpoint).toString().split("#");
            String[] LemmasTokens = priceparts[1].split(",");
            for (int first = 0; first < LemmasTokens.length-1; first++) {
                String currentFeature = LemmasTokens[first];
                sb.append(currentFeature);
                if (currentFeature.equalsIgnoreCase(Toekns)) {
                    mastercount = mastercount + 1;
                }
            }

        }
        return mastercount;
    }

    public static int AmbianceFrequency(String Toekns) {
        int mastercount = 0;
        StringBuilder sb = new StringBuilder();
        for (int startpoint = 0; startpoint < ambianceF.size(); startpoint++) {
            String[] ambiparts = ambianceF.get(startpoint).toString().split("#");
            String[] LemmasTokens = ambiparts[1].split(",");
            for (int first = 0; first < LemmasTokens.length-1; first++) {
                String currentFeature = LemmasTokens[first];
                sb.append(currentFeature);
                if (currentFeature.equalsIgnoreCase(Toekns)) {
                    mastercount = mastercount + 1;
                }
            }

        }
        return mastercount;
    }

    public static int ServiceFrequency(String Toekns) {
        int mastercount = 0;
        StringBuilder sb = new StringBuilder();
        for (int startpoint = 0; startpoint < serviceF.size(); startpoint++) {
            String[] serviceparts = serviceF.get(startpoint).toString().split("#");
            String[] LemmasTokens = serviceparts[1].split(",");
            for (int first = 0; first < LemmasTokens.length-1; first++) {
                String currentFeature = LemmasTokens[first];
                sb.append(currentFeature);
                if (currentFeature.equalsIgnoreCase(Toekns)) {
                    mastercount = mastercount + 1;
                }
            }

        }
        return mastercount;
    }

    public static int restaurantFrequency(String Toekns) {
        int mastercount = 0;
        StringBuilder sb = new StringBuilder();
        for (int startpoint = 0; startpoint < restaurantF.size(); startpoint++) {
            String[] miscparts = restaurantF.get(startpoint).toString().split("#");
            String[] LemmasTokens = miscparts[1].split(",");
            for (int first = 0; first < LemmasTokens.length-1; first++) {
                String currentFeature = LemmasTokens[first];

                if (currentFeature.equalsIgnoreCase(Toekns)) {
                    mastercount = mastercount + 1;
                }
            }

        }
        return mastercount;
    }

    public static int worthFrequency(String Toekns) {
        int mastercount = 0;
        StringBuilder sb = new StringBuilder();
        for (int startpoint = 0; startpoint < worthinessF.size(); startpoint++) {
            String[] miscparts = worthinessF.get(startpoint).toString().split("#");
            String[] LemmasTokens = miscparts[1].split(",");
            for (int first = 0; first < LemmasTokens.length-1; first++) {
                String currentFeature = LemmasTokens[first];

                if (currentFeature.equalsIgnoreCase(Toekns)) {
                    mastercount = mastercount + 1;
                }
            }

        }
        return mastercount;
    }
}
