package utilities;

import com.github.javafaker.Faker;

public class RandomUserDataGenerator {

    public static String generateRandomName(){
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    public static String generateOnlyName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateRandomEmail(){
        String name = generateRandomName().replaceAll("\\s+", "").toLowerCase();
        Faker faker = new Faker();
        String provider = faker.internet().domainName();
        return name + "@" + provider;
    }


    //Probar generación de nombre y correo aleatoriamente
    public static void main(String[] args) {
        String randomName = generateRandomName();
        String randomEmail = generateRandomEmail();
        String onlyName = generateOnlyName();
        System.out.println("Only Name: " + onlyName);
        System.out.println("Random Name: " + randomName);
        System.out.println("Random Email: " + randomEmail);
    }



}
