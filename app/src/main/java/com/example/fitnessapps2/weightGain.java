package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class weightGain extends AppCompatActivity {
    ImageView img1,img2,img3,img4,img5;
    TextView title1,title2,title3,title4,title5;
    TextView description1,description2,description3,description4,description5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_gain);

        img1=findViewById(R.id.img1);
        title1=findViewById(R.id.title1);
        description1=findViewById(R.id.description1);
        img2=findViewById(R.id.img2);
        title2=findViewById(R.id.title2);
        description2=findViewById(R.id.description2);
        img3=findViewById(R.id.img3);
        title3=findViewById(R.id.title3);
        description3=findViewById(R.id.description3);
        img4=findViewById(R.id.img4);
        title4=findViewById(R.id.title4);
        description4=findViewById(R.id.description4);
        img5=findViewById(R.id.img5);
        title5=findViewById(R.id.title5);
        description5=findViewById(R.id.description5);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                img1.setImageResource(R.drawable.wg_7_1);
                title1.setText("Scrambled eggs with whole milk");
                description1.setText("Have two scrambled eggs with whole milk. Serve your breakfast with two slices of whole grain bread and a glass of fresh orange juice.");

                img2.setImageResource(R.drawable.wg_7_2);
                title2.setText("Yoghurt with peaches");
                description2.setText("Have a bowl of yoghurt with peaches.");

                img3.setImageResource(R.drawable.wg_7_3);
                title3.setText("Chicken pasta salad");
                description3.setText("Prepare a plate of chicken pasta salad and have it as your lunch. Have a quarter bar of dark chocolate with it.");

                img4.setImageResource(R.drawable.wg_7_4);
                title4.setText("Sliced avocado with whole grain crackers");
                description4.setText("For an evening snack have a sliced avocado with whole grain crackers.");

                img5.setImageResource(R.drawable.wg_7_5);
                title5.setText("Turkey cooked using vegetable oil");
                description5.setText("Meal like stir-fried turkey cooked using vegetable oil with onions, tomatoes and peppers served with brown rice perfect for dinner.");

                break;

            case Calendar.MONDAY:
                img1.setImageResource(R.drawable.wg_1_1);
                title1.setText("Bowl of whole grain cereal");
                description1.setText("have a bowl of whole grain cereal with whole milk and top it with sliced mango.");

                img2.setImageResource(R.drawable.wg_1_2);
                title2.setText("Crackers with mashed banana");
                description2.setText("Have crackers topped with some mashed banana for your snack.");

                img3.setImageResource(R.drawable.wg_6_3);
                title3.setText("Baked potatoes with tuna");
                description3.setText("For lunch, it is necessary to have heavy food items. You can have baked potatoes with tuna with a generous amount of grated cheese on top.");

                img4.setImageResource(R.drawable.wg_1_4);
                title4.setText("Grilled tilapia with sweet potatoes");
                description4.setText("For dinner have grilled tilapia with sweet potatoes, roasted bell peppers and some couscous.");

                img5.setImageResource(R.drawable.wg_1_5);
                title5.setText("Strawberry smoothie");
                description5.setText("Prepare a strawberry smoothie using whole milk and have it as your post-dinner snack.");

                break;

            case Calendar.TUESDAY:
                img1.setImageResource(R.drawable.wg_2_1);
                title1.setText("Hard-boiled eggs");
                description1.setText("A hard-boiled egg with two toast slices and fresh mango juice.");

                img2.setImageResource(R.drawable.wg_2_2);
                title2.setText("Low-salt potato chips");
                description2.setText("Have a packet of low-salt potato chips with a peach.");

                img3.setImageResource(R.drawable.wg_2_3);
                title3.setText("Ham-salad sandwich with whole grain bread");
                description3.setText("Have a ham-salad sandwich made out of whole grain bread, yoghurt and two squares of dark chocolate.");

                img4.setImageResource(R.drawable.wg_2_4);
                title4.setText("Salmon and prawns pasta");
                description4.setText("For dinner cook some salmon and prawns in using vegetable oil and serve it with whole wheat pasta and tomato sauce.");

                img5.setImageResource(R.drawable.wg_2_5);
                title5.setText("Banana and peanut smoothie");
                description5.setText("Prepare a banana and peanut smoothie with whole milk and have it as snack.");
                break;

            case Calendar.WEDNESDAY:
                img1.setImageResource(R.drawable.wg_3_1);
                title1.setText("Oatmeal topped with mangoes");
                description1.setText("For the breakfast have oatmeal cooked using whole milk topped with fresh mangoes and chopped almonds.");

                img2.setImageResource(R.drawable.wg_3_2);
                title2.setText("Curd, raisins and cereal bar");
                description2.setText("Prepare a mix of curd, raisins and cereal bar and have it as your snack.");

                img3.setImageResource(R.drawable.wg_3_3);
                title3.setText("Peanut butter sandwich with whole grain bread");
                description3.setText("Cook a peanut butter sandwich with whole grain bread. Drink a glass of fresh juice and cookie with the sandwich.");

                img4.setImageResource(R.drawable.wg_3_4);
                title4.setText("Salad with lentils, mackerel and anchovies");
                description4.setText("Prepare a salad with lentils, mackerel and anchovies, drizzle some olive oil on it and have it with whole grain bread");

                img5.setImageResource(R.drawable.wg_3_5);
                title5.setText("Banana smoothie");
                description5.setText("Drink a banana smoothie made using whole milk.");

                break;

            case Calendar.THURSDAY:
                img1.setImageResource(R.drawable.wg_7_1);
                title1.setText("Scrambled eggs with whole milk");
                description1.setText("Have two scrambled eggs with whole milk. Serve your breakfast with two slices of whole grain bread and a glass of fresh orange juice.");

                img2.setImageResource(R.drawable.wg_5_2);
                title2.setText("Chicken and Pasta Salad");
                description2.setText("Cooked chicken + pasta + 1 cup leafy green vegetables + tomato + avocado + crumbled feta cheese + olive oil/vinegar dressing.");

                img3.setImageResource(R.drawable.wg_2_3);
                title3.setText("Ham-salad sandwich with whole grain bread");
                description3.setText("Have a ham-salad sandwich made out of whole grain bread, yoghurt and two squares of dark chocolate.");

                img4.setImageResource(R.drawable.wg_3_4);
                title4.setText("Salad with lentils, mackerel and anchovies");
                description4.setText("Prepare a salad with lentils, mackerel and anchovies, drizzle some olive oil on it and have it with whole grain bread.");

                img5.setImageResource(R.drawable.wg_1_5);
                title5.setText("Strawberry smoothie");
                description5.setText("Prepare a strawberry smoothie using whole milk and have it as your post-dinner snack.");

                break;

            case Calendar.FRIDAY:
                img1.setImageResource(R.drawable.wg_5_1);
                title1.setText("Peanut Butter on Wholegrain Toast");
                description1.setText("Toasted wholegrain bread + 2 tbsp peanut butter. Drizzle with honey to taste. Serve with 1 hot chocolate, made with milk + 1 serve of fruit");

                img2.setImageResource(R.drawable.wg_5_2);
                title2.setText("Chicken and Pasta Salad");
                description2.setText("Cooked chicken + pasta + 1 cup leafy green vegetables (eg. spinach, rocket) + tomato + avocado + crumbled feta cheese + olive oil/vinegar dressing.");

                img3.setImageResource(R.drawable.wg_5_3);
                title3.setText("Lamb Chops and Vegetables");
                description3.setText("Lamb chop, trimmed & shallow fried in olive oil. Serve with sweet potato mash made with milk and olive oil + 2 cups cooked vegetables.");

                img4.setImageResource(R.drawable.wg_5_4);
                title4.setText("Fresh Fruit and Cheese Platter");
                description4.setText("Slice and serve a variety of fresh fruits in season and cheese.");

                img5.setImageResource(R.drawable.wg_5_5);
                title5.setText("Nuts and Seeds");
                description5.setText("A handful of mixed nuts and/or seeds.");

                break;

            case Calendar.SATURDAY:
                img1.setImageResource(R.drawable.wg_6_1);
                title1.setText("Oatmeal with whole milk");
                description1.setText("For breakfast, have a bowl of oatmeal with whole milk, dried fruits and nuts. You can have a glass of orange juice with it.");

                img2.setImageResource(R.drawable.wg_6_2);
                title2.setText("Cereal bar");
                description2.setText("Have a cereal bar with banana as your snack.");

                img3.setImageResource(R.drawable.wg_6_3);
                title3.setText("Baked potatoes with tuna");
                description3.setText("You can have baked potatoes with tuna with a generous amount of grated cheese on top. A portion of fruit gelatin and heavy dessert can also be eaten.");

                img4.setImageResource(R.drawable.wg_6_4);
                title4.setText("Grilled chicken with avocado");
                description4.setText("you can have a portion of grilled chicken with avocado salad and whole grain bread. You can also add olive oil to your food.");

                img5.setImageResource(R.drawable.wg_6_5);
                title5.setText("A bowl of yoghurt with fruits");
                description5.setText("For dessert have a bowl of yoghurt and top it with seasonal fruits. Have a glass of vanilla smoothie made out of whole milk.");

                break;
        }
    }
}