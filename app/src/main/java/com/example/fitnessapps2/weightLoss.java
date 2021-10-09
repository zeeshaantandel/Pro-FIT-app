package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class weightLoss extends AppCompatActivity {
    ImageView img1,img2,img3,img4,img5;
    TextView title1,title2,title3,title4,title5;
    TextView description1,description2,description3,description4,description5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss);

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
                img1.setImageResource(R.drawable.wl_7_1);
                title1.setText("Buckwheat Porridge");
                description1.setText("Buckwheat porridge with sliced mango/ fruit salad with a glass of milk");

                img2.setImageResource(R.drawable.wg_7_2);
                title2.setText("Yoghurt with peaches");
                description2.setText("Have a bowl of yoghurt with peaches.");

                img3.setImageResource(R.drawable.wl_7_3);
                title3.setText("Vegetable soup with whole-grain roti");
                description3.setText("Vegetable soup with whole-grain roti/ one bowl millet and dal khichdi with multigrain roti");

                img4.setImageResource(R.drawable.wl_7_4);
                title4.setText("Masala-baked tofu");
                description4.setText("Masala-baked tofu with vegetable curry/ non veg curry (chicken, seafood) with multigrain roti");

                img5.setImageResource(R.drawable.wg_7_4);
                title5.setText("Sliced avocado with whole grain crackers");
                description5.setText("Have a sliced avocado with whole grain crackers.");

                break;

            case Calendar.MONDAY:
                img1.setImageResource(R.drawable.wl_1_1);
                title1.setText("Sambar with brown rice idlis");
                description1.setText("Sambar with 2 brown rice idlis/ Paneer sandwich with mint chutney");

                img2.setImageResource(R.drawable.wg_1_2);
                title2.setText("Crackers with mashed banana");
                description2.setText("Have crackers topped with some mashed banana for your snack.");

                img3.setImageResource(R.drawable.wl_1_3);
                title3.setText("Mixed-vegetable curry");
                description3.setText("Whole-grain roti with mixed-vegetable curry with one dal");

                img4.setImageResource(R.drawable.wl_1_4);
                title4.setText("Chicken curry with mixed vegetables");
                description4.setText("Tofu/chicken curry with mixed vegetables and a fresh spinach salad/chicken gravy with 2 multigrain rotis");

                img5.setImageResource(R.drawable.wg_1_5);
                title5.setText("Strawberry smoothie");
                description5.setText("Prepare a strawberry smoothie using whole milk and have it as your post-dinner snack.");

                break;

            case Calendar.TUESDAY:
                img1.setImageResource(R.drawable.wl_2_1);
                title1.setText("Chana dal pancakes");
                description1.setText(" Chana dal pancakes with mixed vegetables and a glass of milk/ bread and egg with fruits");

                img2.setImageResource(R.drawable.wg_2_2);
                title2.setText("Low-salt potato chips");
                description2.setText("Have a packet of low-salt potato chips with a peach.");

                img3.setImageResource(R.drawable.wl_2_3);
                title3.setText("Chickpea curry with brown rice");
                description3.setText("Chickpea curry with brown rice/ Brown rice with dal");

                img4.setImageResource(R.drawable.wl_2_4);
                title4.setText("Khichdi with sprout salad");
                description4.setText("Khichdi with sprout salad/Veg paratha with raita");

                img5.setImageResource(R.drawable.wg_2_5);
                title5.setText("Banana and peanut smoothie");
                description5.setText("Prepare a banana and peanut smoothie with whole milk and have it as snack.");

                break;

            case Calendar.WEDNESDAY:
                img1.setImageResource(R.drawable.wl_3_1);
                title1.setText("Apple cinnamon porridge");
                description1.setText("Apple cinnamon porridge/ Vegetable uttapam with sambhar");

                img2.setImageResource(R.drawable.wg_5_2);
                title2.setText("Chicken and Pasta Salad");
                description2.setText("Cooked chicken + pasta + 1 cup leafy green vegetables + tomato + avocado + olive oil/vinegar dressing.");

                img3.setImageResource(R.drawable.wl_3_3);
                title3.setText("Whole-grain roti with tofu");
                description3.setText("Whole-grain roti with tofu/ non veg and mixed vegetables");

                img4.setImageResource(R.drawable.wl_3_4);
                title4.setText("Palak paneer with brown rice");
                description4.setText("Palak paneer with brown rice and vegetables/ 2 Multigrain rotis with chicken and curd");

                img5.setImageResource(R.drawable.wg_1_5);
                title5.setText("Strawberry smoothie");
                description5.setText("Prepare a strawberry smoothie using whole milk and have it as your post-dinner snack.");

                break;

            case Calendar.THURSDAY:
                img1.setImageResource(R.drawable.wl_4_1);
                title1.setText("Yogurt with sliced fruits");
                description1.setText("Yogurt with sliced fruits and sunflower seeds/ vegetable poha");

                img2.setImageResource(R.drawable.wg_6_2);
                title2.setText("Cereal bar");
                description2.setText("Have a cereal bar with banana as your snack.");

                img3.setImageResource(R.drawable.wl_4_3);
                title3.setText("Roti with vegetable sabzi");
                description3.setText("Whole-grain roti with vegetable sabzi/ Dal with veg or non veg sabzi and brown rice");

                img4.setImageResource(R.drawable.wl_4_4);
                title4.setText("Chana masala with basmati rice");
                description4.setText("Chana masala with basmati rice and green salad/ One bowl of fruits and vegetables with multigrain rotis");

                img5.setImageResource(R.drawable.wg_5_5);
                title5.setText("Nuts and Seeds");
                description5.setText("A handful of mixed nuts and/or seeds.");

                break;

            case Calendar.FRIDAY:
                img1.setImageResource(R.drawable.wl_5_1);
                title1.setText("Vegetable dalia");
                description1.setText("Vegetable dalia and a glass of milk/ 3-4 dal paddu with sambar");

                img2.setImageResource(R.drawable.wg_3_2);
                title2.setText("Curd, raisins and cereal bar");
                description2.setText("Prepare a mix of curd, raisins and cereal bar and have it as your snack.");

                img3.setImageResource(R.drawable.wl_5_3);
                title3.setText("Vegetable sambar with brown rice");
                description3.setText("Vegetable sambar with brown rice/ 2 multigrain roti with veg/non veg curry");

                img4.setImageResource(R.drawable.wl_5_4);
                title4.setText("Tofu curry with potatoes");
                description4.setText("Tofu curry with potatoes and mixed vegetables/ chicken curry with 2 multigrain rotis");

                img5.setImageResource(R.drawable.wg_3_5);
                title5.setText("Banana smoothie");
                description5.setText("Drink a banana smoothie made using whole milk.");

                break;

            case Calendar.SATURDAY:
                img1.setImageResource(R.drawable.wl_6_1);
                title1.setText("Multigrain parathas with avocado");
                description1.setText("Multigrain parathas with avocado and sliced papaya/ dal paratha with mixed vegetables");

                img2.setImageResource(R.drawable.wg_5_2);
                title2.setText("Chicken and Pasta Salad");
                description2.setText("Cooked chicken + pasta + 1 cup leafy green vegetables + tomato + avocado + olive oil/vinegar dressing.");

                img3.setImageResource(R.drawable.wl_6_3);
                title3.setText("Salad with rajma curry");
                description3.setText("Large salad with rajma curry and quinoa/ one bowl mixed vegetable kadai");

                img4.setImageResource(R.drawable.wl_6_4);
                title4.setText("Lentil pancakes");
                description4.setText("Lentil pancakes with tofu tikka masala/ green salad with mixed vegetables and multigrain roti");

                img5.setImageResource(R.drawable.wg_5_5);
                title5.setText("Nuts and Seeds");
                description5.setText("A handful of mixed nuts and/or seeds.");
                break;
        }
    }
}