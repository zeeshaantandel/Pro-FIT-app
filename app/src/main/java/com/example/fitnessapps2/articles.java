package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.fitnessapps2.R.drawable.background8;

public class articles extends AppCompatActivity {
    public BottomNavigationView bottomNavigationView;
    private TextView articles_textview;
    private TextView articles_heading_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.articles);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.diet:
                        startActivity(new Intent(getApplicationContext(),dietPlans.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.record:
                        startActivity(new Intent(getApplicationContext(),trackActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.articles:
                        return true;

                    case R.id.workouts:
                        startActivity(new Intent(getApplicationContext(),workouts.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profile_and_settings.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        ViewPager viewpager_articles = findViewById(R.id.viewpager_articles);
        ImageAdapterArticles adapter = new ImageAdapterArticles(this);
        viewpager_articles.setAdapter(adapter);
        TextView articles_textview=findViewById(R.id.articles_textview);
        TextView articles_heading_textview=findViewById(R.id.articles_heading_textview);

        viewpager_articles.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        articles_heading_textview.setText("");
                        articles_textview.setText("");
                        break;

                    case 1:
                        articles_textview.setText("If there’s one exercise that should win the gold for its impressive list of benefits — and minimal risks — it’s walking. Plus it’s convenient (just think, no equipment!) and it’s contraindicated for very few conditions and comorbidities.\n" +
                                "\n" +
                                "You may be wondering: If it’s an activity that can help someone in their nineties stay fit — can it really provide benefits for everyone?\n" +
                                "\n" +
                                "Yes, people of all ages and fitness levels, from newbies to elite-level athletes, can get many of the same benefits running provides by doing walking workouts — with the right techniques.\n" +
                                "\n" +
                                "The Health Benefits of Walking\n" +
                                "Truth is, walking and running share numerous pros, with one main difference. “Although both activities work the same muscles and joints, burn calories, and strengthen the heart and lungs, they differ in impact,” says Juliet Kaska, a Los Angeles–based ACE- and NASM-certified personal trainer and the founder of Juliet Kaska’s Zen Fitness.\n" +
                                "\n" +
                                "Running is a high-impact activity, which can strain the joints, ligaments, and tendons, Kaska says. That’s why walking can be a fantastic option when runners want to take a day off running but still do an aerobic workout.\n" +
                                "\n" +
                                "The one downside of walking? “Walking takes more time to cover the same distance,” says Bonnie Stoll, a personal trainer in Los Angeles and a cofounder of EverWalk, a movement designed to get people walking more. This is why you may burn more calories after 30 minutes of running than 30 minutes of walking. But depending on your speed, you can get similar effects from walking three miles as running three miles; the biggest difference being that walking is low-impact.\n" +
                                "\n" +
                                "What does the science say about the health benefits of walking?\n" +
                                "\n" +
                                "One benefit is longer life. Just by walking at a pace that makes you slightly out of breath or sweaty, you may lower your risk of heart disease and death from all causes than with regular walking at a more leisurely pace, according to a study published in May 2018 in the British Journal of Sports Medicine. That same brisk walking can also lower your risk of high cholesterol, high blood pressure, and diabetes as much as running, according to other research.\n" +
                                "\n" +
                                "Over time, science has found a link between walking and improved cognitive function and lower risk of dementia and Alzheimer’s disease, such as in study published in January 2018 in the Journal of Alzheimer's Disease.  \n" +
                                "\n" +
                                "Walking has also been shown to improve conditions like knee osteoarthritis (according to research) and back pain (according to other research). And a study published in October 2019 in the journal Sleep Health found that simply taking more steps during the day was linked to improved sleep quality (and more so for women than for men).\n" +
                                "\n" +
                                "Walking can also help prevent bone loss that happens naturally as a result of age, particularly if you up the intensity of your steps by climbing stairs, pick up the pace, or add bodyweight exercises (like push-ups or squats) throughout your walk, according to Mayo Clinic.\n" +
                                "\n" +
                                "Physical activity guidelines from the U.S. Department of Health and Human Services (HHS) for adults define brisk walking as a type of moderate exercise linked with optimal long-term health and lower risk of excess weight gain. Those guidelines say aim for 150 to 300 minutes per week.\n" +
                                "\n" +
                                "The mental benefits of walking are equally impressive (which should come as no surprise given that exercise overall is one of the top ways to manage stress). Walking is indeed a great stress reliever, Kaska says. A study published in March 2019 in the International Journal of Environmental Research and Public Health, for example, showed that people who participated in at least one group walk in nature per week saw positive effects when it came to managing stressful life events and improving mental well-being.\n" +
                                "\n" +
                                "Research has even shown that walking can improve creative thinking, even more so when the walk is done outside.\n" +
                                "\n" +
                                "How to Make Walking a Workout\n" +
                                "Fortunately, walking for fitness comes with almost no learning curve. It's different from a casual stroll with your best friend or dog, but it's easy to do with some extra attention to your speed and form.\n" +
                                "\n" +
                                "Speed\n" +
                                "Speed might sound alarming at first, but don’t think you have to break racewalking records. If you want to boost that fitness, studies show that brisk walking is best, and of course, “brisk” will depend on your current fitness level. If you’re new to walking for fitness or exercise overall, shoot for a 20-minute mile to start, Stoll says. Otherwise, see if you can move at a 15-minute-mile pace.\n" +
                                "\n" +
                                "Another way to gauge your speed and intensity: Pay attention to your breathing. If you’re walking briskly, you should be breathing heavier, but still able to carry on a conversation, according to the American Heart Association.\n" +
                                "\n" +
                                "Form\n" +
                                "Want to improve that speed? Make sure you’re using a heel-toe motion in your feet. “Pretend you have somebody behind you and you want to show them what’s on the bottom of your shoe with each step,” Stoll says. That roll through your foot should help propel you forward.\n" +
                                "\n" +
                                "At the same time, hold your arms at 90-degree angles and pump them forward and back, not across our body. “As you increase your elbow pump, your feet will follow,” Stoll says, adding that if you swing them across your body, it may impede your speed.\n" +
                                "\n" +
                                "Now get a baseline reading of how long it takes you to walk a mile. Head to a track and log the time it takes you to complete one lap, usually one-quarter mile. Do a second lap and see if you can walk just five seconds faster, Stoll says.");
                        articles_heading_textview.setText("How to Make Walking a Workout?");
                        break;

                    case 2:

                        articles_textview.setText("Has the COVID-19 pandemic put you in a workout slump? If your fitness habits aren’t what they used to be, rest assured — you’re in good company.\n" +
                                "\n" +
                                "A growing body of evidence shows that the pandemic has profoundly changed how much people exercise, not only in the United States but around the world. In a study published in November 2020 in the Annals of Internal Medicine, researchers found that, based on more than 19 million smartphone-based, step-counting measurements taken from January 19 to June 1, 2020, physical activity levels dropped dramatically in many countries after the pandemic struck.\n" +
                                "\n" +
                                "In a study published in February 2021 in the Journal of Medical Internet Research, experts used an activity-tracking smartphone app to look at the exercise habits of nearly 5,400 people in the United Kingdom since the start of the pandemic. When it came to walking, running, and cycling, activity levels initially dropped the most in people who had been the most active before the pandemic, as well as in people ages 65 or younger. And once pandemic restrictions were eased, only people older than 65 appeared to bounce back with their physical activity.\n" +
                                "\n" +
                                "“I’m seeing people who were formerly active — who used to go to the gym a lot or group exercise classes — and they stopped doing that because of the pandemic,” says Cindy Lin, MD, a clinical associate professor of sports and spine medicine and assistant director of clinical innovation at the Sports Institute at the University of Washington School of Medicine in Seattle. She typically sees patients who are having trouble with sports or exercise for a variety of reasons, sometimes due to musculoskeletal problems like tendon injuries or osteoarthritis.\n" +
                                "\n" +
                                "Brandee L. Waite, MD, director of physical medicine and rehabilitation for the sports medicine fellowship at the University of California in Davis, says she isn’t surprised that people have struggled to maintain their workout routines during the pandemic.\n" +
                                "\n" +
                                "“Whenever there is a disruption in your normal day-to-day routine, the things that seem to get compromised are the things that don’t make you money or don’t take care of your family,” she explains — and frequently your own personal fitness is one of the things that gets left by the wayside.\n" +
                                "\n" +
                                "You may be less motivated to exercise if feelings of isolation from social distancing are causing your mental health to plummet, Dr. Waite notes. Even though physical activity can be a great antidote for lifting mood and easing depression, anxiety, and stress, struggling with any of them can make you less motivated to get moving in the first place. And depending on where you live, you may also have fewer opportunities to exercise because of gym closures and working from home, she adds.\n" +
                                "\n" +
                                "But even if you have time on your hands and aren’t noticeably depressed, you may still find it harder to exercise than you did before, now that the COVID-19 pandemic has likely flipped your normal schedule upside down. “Sometimes when we have more time, we’re like, ‘I’ll do it later,’” says James Houle, PhD, who specializes in sport psychology at the Ohio State University Wexner Medical Center in Columbus. Whereas if you have a lot going on, you’ll schedule in exercise and stick to that plan, he says.\n" +
                                "\n" +
                                "Whether your workouts have been disrupted by gym closures, increased family responsibilities, or difficulty staying motivated as the pandemic wears on, here are seven tips that may help you get back on track.\n" +
                                "\n" +
                                "1. Set Goals and a Timeline\n" +
                                "One way to motivate yourself, says Dr. Houle, is by setting small, realistic, and measurable goals that you can write down in a list and check off one by one.\n" +
                                "\n" +
                                "For example, Houle says, if you’re trying to get stronger by doing push-ups, you can start by doing a number that’s manageable for you, either each day or on certain days of the week. Then try to gradually increase that number as time goes on. The same principle can apply to any activity, such as running or jogging a certain distance or length of time.\n" +
                                "\n" +
                                "For many people, scheduling workouts in advance is a critical first step toward actually doing them, adds Waite. “I think putting something on your schedule, on the calendar as an appointment that you block off, means you’re much more likely to adhere to it,” she explains.\n" +
                                "\n" +
                                "But be realistic, says Houle. If you like to exercise in the evening, it can be a great way to blow off steam, he says. If you like to knock out your workouts at the beginning of the day (before you get distracted with other things), schedule them for first thing in the morning.\n" +
                                "\n" +
                                "2. Hold Yourself Accountable\n" +
                                "Having another person holding you accountable to exercise often means you’re more likely to follow through with your goals, says Houle. And an accountability partner doesn’t necessarily need to join you in person, he adds.\n" +
                                "\n" +
                                "“I’ve had people call or text each other. Or on different apps you can share workouts,” Houle explains. “That kind of stuff can be motivating and fun.”\n" +
                                "\n" +
                                "And, yes, turn to technology. “There are a variety of apps and wearable devices that can help support people in moving more,” Dr. Lin notes. Some provide challenges and full workout plans, while others simply have you tracking movement (like laps swum, miles run, or wheelchair pushes), she adds.\n" +
                                "\n" +
                                "3. Ease Back Into Exercise\n" +
                                "No matter how fit you are — or were — if you’ve spent a period of time (longer than a few weeks) out of an exercise routine, it’s important to gradually work back up to that same intensity.\n" +
                                "\n" +
                                "“Where I see a lot of people get discouraged is if they think, How come I can’t do it the way I used to do it? That’s kind of unfair,” says Houle. It’s key to acknowledge that your routine has been disrupted, rather than try to prove you’re still as fit as you used to be, he advises.\n" +
                                "\n" +
                                "As a general rule, says Waite, if you’ve been inactive for longer than a month, you should resume your physical activity at 25 to 50 percent of the level you were previously accustomed to (either for time or intensity). For most people, she says, 50 percent is a good starting point. Then increase it by about 10 to 15 percent per week, which she recommends as “a good guideline to avoid injury.”\n" +
                                "\n" +
                                "And don’t be discouraged if you need to increase the time or intensity more gradually. Waite says, “Some people have to increase it by 10 percent every 2 weeks. You have to listen to your body.”\n" +
                                "\n" +
                                "4. Break It Up\n" +
                                "Getting in a workout doesn’t always mean you have to block off an uninterrupted hour of your time. In fact, there are benefits to shorter workouts throughout the day.\n" +
                                "\n" +
                                "“We know that the average American sits about seven hours a day, and that has negative health effects,” says Lin. Taking regular breaks from sitting to do a 5- or 10-minute body weight exercise, or even just to move around, can add up for cumulative health benefits.\n" +
                                "\n" +
                                "If you don’t have the time or stamina to go for an hour-long run, Lin suggests running or jogging in intervals of 5 to 10 minutes. Or try a 5- to 10-minute strength training workout that you can do in whatever space you have available, she says.\n" +
                                "\n" +
                                "RELATED: 5-Minute, Full-Body Strength Workout With Kelsey Wells\n" +
                                "\n" +
                                "It might help you to visualize shorter workouts is as “fitness snacking,” rather than a large “meal” that you would get from a longer workout, Waite says. In the end, multiple fitness snacks throughout the day might add up to one large meal.\n" +
                                "\n" +
                                "But don’t beat yourself up if you only manage to get a single fitness snack on some days. “Even a 15-minute workout is better than no workout,” Waite says.\n" +
                                "\n" +
                                "5. Make Your Workouts Social (Safely)\n" +
                                "Exercise can make us stronger and keep our bodies healthy, but for a lot of us, at least before the pandemic, it was an opportunity to socialize, too — at the gym, in a workout class, or as part of a running or walking group. For those missing this latter component, it’s no wonder it’s been hard to stick with an exercise routine.\n" +
                                "\n" +
                                "If you live in an area where it’s safe to attend group exercise classes at a gym, and you’re comfortable doing so with the right safety measures, check out what options are available in your area, Waite suggests. Some gyms and personal trainers are offering outdoor classes, too.\n" +
                                "\n" +
                                "But if you’re not ready for in-person classes just yet, many gyms have pivoted to on-demand or even live virtual classes, Waite says. You can check with your local gym to see if they offer virtual options that allow you to interact with instructors or other gym members.\n" +
                                "\n" +
                                "You could also opt for a walk or jog with a friend or family member, as social distancing practices allow. Or if you have to look after kids, you could make your workouts a family affair, Lin says. “Turn on the radio or play a song on YouTube, and you and your kids can dance to it,” she suggests.\n" +
                                "\n" +
                                "6. Get Outside\n" +
                                "Whether you’re working out alone or with someone else, breaking a sweat in the great outdoors can reduce stress and immerse you in nature.\n" +
                                "\n" +
                                "“There are a lot of studies showing that just being in nature, in the outdoors, has a lot of benefits for improving physical and mental health,” says Lin. In one study published in June 2019 in the journal Scientific Reports, researchers found that spending at least 120 minutes per week in a natural environment — such as a park, forest, or beach — was linked to significant improvement in self-reported health and well-being, with the greatest benefits seen in people who spent 200 to 300 minutes per week in nature.\n" +
                                "\n" +
                                "Waite notes that when weather allows, many gyms have moved group exercise classes outside. And even if these options aren’t offered in your area, you may prefer to work out on your own outside, whether by watching an exercise video in your backyard or trying body-weight strength exercises in a local park.\n" +
                                "\n" +
                                "Lin also recommends checking out the Sports Institute's free exercise video resources.\n" +
                                "\n" +
                                "7. Be Your Own Cheerleader\n" +
                                "If you haven’t worked out in a while, exercise can sometimes feel like a chore. It can be easy to beat yourself up and feel like you’re lazy or weak for not getting it done. If you struggle with this mindset, Waite suggests reframing exercise as an enjoyable activity that you look forward to. (Note: It’s easier to think of exercise as enjoyable if you start by picking workouts you do indeed find enjoyable.)\n" +
                                "\n" +
                                "Self-talk related to exercise definitely affects mindset, Houle says. “If I get up in the morning, and I go, ‘Man, I didn’t exercise yesterday. I’m so lazy,’ and I repeat that, I’m going to start to believe that,” he says.\n" +
                                "\n" +
                                "Instead, he suggests using positive self-talk to help you motivate yourself to exercise. “Get up and go, ‘This is what I’m going to do today, it’s going to feel good, and I can do this.’ It’s going to feel silly in the beginning, but if you stick with it, you’ll feel more motivated and excited about exercising,” Houle says.\n" +
                                "\n");
                        articles_heading_textview.setText("7 Tips for Getting Back Into a Workout Routine if the Pandemic Disrupted Yours");
                        break;

                    case 3:
                        articles_textview.setText("While \"fat-burning food\" sounds too good to be true, you can elevate your weight loss goals by incorporating more food that spikes metabolism, enhances digestion, and helps you feel full.\n"+
                                "\n"+"Weight loss can start with shopping. And taking control of what you eat begins with taking control of what you buy. It takes dedication and motivation to shy away from those unhealthy and tasty snacks that are often loaded with sugar or fat, and are high in calories. You can increase your body’s fat-burning power by eating more foods that help your liver (your body’s main fat-metabolizing organ) to burn fat better, resulting in a leaner body.\n" +
                                "\n" +
                                "While it can be tempting at times to take the easy route by taking fat-burning supplements, it is important to note that there is little scientific evidence available that proves these effective. Why ingest a supplement when you can consume foods that not only help you lose fat but make you feel good and give you energy?\n" +
                                "\n" +
                                "Fresh and natural foods have so many benefits to our health, and one of the most important benefits, when it comes to burning all of that unwanted fat, is the ability to reduce inflammation among our bodies. And when you eat more nutritious foods that have the potential to fight fat, you do not have to restrict your intake as much and can eat throughout the day.\n" +
                                "\n" +
                                "Many foods help fight weight gain, but these are some of our picks.\n" +
                                "\n" +
                                "Eggs\n" +
                                "Get to cracking because eggs are a great way to start your day. Not only do they provide your body with high-quality protein that can increase metabolism, but they help increase satiety (feelings of fullness) and reduce hunger. Studies show that when you consume a high-protein breakfast that includes eggs, a reduction in weight and belly fat can occur. Who knew that eggs could get rid of muffin tops. Plus, the yolk is a good source of iron, and it’s loaded with lecithin, critical for brain health.\n" +
                                "\n" +
                                "Avocados\n" +
                                "The cholesterol-lowering monounsaturated fat in these green health bombs can help keep your body strong and pain-free. Sports-medicine researchers found that competitive women runners who ate less than 20% fat were more likely to suffer injuries than those who consumed at least 31%. The problem is linked to extreme low-fat diets, which weaken muscles and joints. Yet a few slices of avocado a day are a great way to boost fat for the fat shy.\n" +
                                "\n" +
                                "Bananas\n" +
                                "Thanks to bananas’ high potassium content, peeling one is a speedy solution to that stitch in your side. While a lack of sodium is the main culprit behind muscle cramps, studies show potassium plays a supporting role. Bananas are also packed with energizing carbohydrates. One medium-sized fruit has 400 milligrams of potassium and as many carbs (29 grams) as two slices of whole-wheat bread.\n" +
                                "\n" +
                                "Dark leafy greens\n" +
                                "Dark leafy greens, such as kale, collard greens, Swiss chard, and spinach, are high in the anti-stress nutrient magnesium — stress has a direct connection to weight management— and add important fiber and nutrients for overall health, satiety, and fat-burning capabilities. With lots of iron in these leaves to help carry oxygen throughout your body, you’ll be more efficient in your workouts and build muscle too. The more muscle you have, the more fat you burn at rest.\n" +
                                "\n" +
                                "Quinoa\n" +
                                "The new alternative for carb cravings, quinoa is a whole grain food that contains nine amino acids. Amino acids are the building blocks of protein that have been shown to improve the synthesis of muscle and the reduction of fat when consumed in a diet. It is also very easy to cook and can become a part of your menu cycle for quick lunches and dinners. Just mix in vegetables and a lean protein for a quinoa bowl or even some fruits and nuts for a delicious and nutritious quinoa salad.  \n" +
                                "\n" +
                                "Garlic and onions\n" +
                                "This dynamic duo of foods contains phytochemicals that break down fatty deposits in the body, while also breaking down cholesterol. The pair also assists in killing viruses, bacteria, and fungi while protecting against heart disease.\n" +
                                "\n" +
                                "Fish\n" +
                                "As weird as it may sound, eating fatty fish can help you cut out fat. The reason for this phenomenon is that fatty fishes contain omega-3 fatty acids. These fatty acids work in reducing the amount of LDL (bad cholesterol) that can build up in your bloodstream.\n" +
                                "\n" +
                                "Oatmeal\n" +
                                "This filling fiber food also promotes the lowering of insulin levels, which researchers have speculated aids in shrinking all of those unwanted fat cells. To receive all of these healthful benefits, be sure to create your oatmeal with steel-cut oats and try to refrain from purchasing the sugary filled packs of oatmeal at the store. Instead, add cinnamon or nutmeg to trick your taste buds for a sweeter taste.\n" +
                                "\n" +
                                "Carrots\n" +
                                "Close your eyes, and they almost taste like crunchy candy. Carrots pack complex carbs that provide energy to muscles and potassium to control blood pressure and muscle contractions. And a half cup has just 35 calories.\n" +
                                "\n" +
                                "Nuts\n" +
                                "Nuts are also good sources of those omega-3 fatty acids. The nuts that contain the highest amounts of fatty acids include walnuts, macadamia, pecans, cashews, pistachios, and almonds. It is important to note that although nuts do contain health benefits, they also are high in calories. Therefore, limit your portions to about a small handful.  \n" +
                                "\n" +
                                "Chicken thighs\n" +
                                "Skimp on iron and zinc, and your energy wanes. We’re big on chicken breasts, but for energy, juicy chicken thighs or turkey drumsticks are the best way to get more of both. Dark-meat poultry is significantly lower in fat than red meat yet has all the iron, zinc, and B vitamins that many people need in their diets.\n" +
                                "\n" +
                                "Olives and olive oil\n" +
                                "Being rich in healthy fats, olives and olive oil help to reduce cravings for junky foods and keep you feeling full. Research shows that monosaturated fats that are plentiful in these foods also help reduce high blood pressure.\n" +
                                "\n" +
                                "Ground flaxseed\n" +
                                "These seeds and oil attract fat-soluble toxins that become lodged in the fatty tissues of the body. Once attracted, they help to escort toxins out. That spells fewer fat stores and a trimmer you. Flaxseed is full of fibers called lignans that promote gut health. Since flax lignans contain both soluble and insoluble fiber, they keep you regular as well.\n" +
                                "\n" +
                                "Green tea\n" +
                                "Green tea is truly one of the only natural fat-burning drinks available. It has a robust antioxidant profile. The high amount of EGCG — epigallocatechin gallate — triggers enzymes that get fat cells to release their stored fat and increase the amount of fat used for energy. Green tea also enhances the liver’s fat-burning capabilities and thermogenesis, a heat-producing process in the body.");
                        articles_heading_textview.setText("Battle of the Bulge");
                        break;

                    case 4:
                        articles_heading_textview.setText("How to Exercise if You Have a Mesomorph Body Type?");
                        articles_textview.setText("How do you know if you have a mesomorph body type? You might love Tabata and other high-intensity interval training (HIIT) workouts, but find long bouts of cardio arduous. You may naturally enjoy the weight room because that’s where your strengths — no pun intended — lie.\n" +
                                "\n" +
                                "“A mesomorph is generally defined as someone who has a body type that has a high level of muscle and strength,” says Adam Feit, the head strength and sports psychology coach for Precision Nutrition in Springfield, Massachusetts. Now, perhaps you don’t have lots of muscle at the moment because you’ve been inactive for a while. But you know if you did start working out, you would gain muscle relatively easily.\n" +
                                "\n" +
                                "Football players (think linebackers, cornerbacks, and running backs) and gymnasts often have mesomorph body types, as muscle and power tend to allow these athletes to be more successful in their sports. Non-professional-athlete mesomorphs may notice that they can build muscle with a weight-focused strength routine easily, but they’re also likely to gain weight or fat.\n" +
                                "\n" +
                                "The other main body types, also called somatotypes, are ectomorph (long and lanky) and endomorph (curvy). Somatotype theory builds on work from the mid-20th century by the psychologist William Sheldon, who defined these body types. Much of Sheldon’s work linking these body types to various personality traits was debunked, according to the National Academy of Sports Medicine. And there’s still not a large amount of evidence behind the diet and exercise recommendations for the various body types, but some data does suggest that eating and exercise can have different effects on people with different body types — and that learning your body type can help you address deficits in your strength, cardio, or flexibility.\n" +
                                "\n" +
                                "While some people are strictly one body type or another, many are combinations of these three somatotypes, Feit says. Some people may even notice differences among different muscle groups. For instance, you can easily build muscle and bulk up in your legs and glutes (mesomorph body type tendency), but you really struggle to build upper body strength (ectomorph body type tendency). For that reason, there isn’t one guideline that will work for everyone who identifies fully or, in part, as a mesomorph. “I encourage you not to allow these basic categories to become a rule you must follow,” he says.\n" +
                                "\n" +
                                "If you do have a mesomorph body type, you may find that these training tips will help you reap the exercise gains you seek.\n" +
                                "\n" +
                                "What Types of Exercises Should You Do if You Have a Mesomorph Body Type?\n" +
                                "For people who build muscle readily, they may find that they gravitate toward the activity that they’re good at: strength training. That’s according to American College of Sports Medicine fellow Stuart Phillips, PhD, a professor, the director of the Physical Activity Centre of Excellence, and the director of the McMaster Centre for Nutrition, Exercise and Health Research at McMaster University in Hamilton Ontario. Dr. Phillips says he mostly identifies with the mesomorph body type, and, while it doesn't resolve everything, knowing his type did give him some insight on what works best for him.\n" +
                                "\n" +
                                "“After running marathons, I realized I wasn’t made to pound up and down pavement. I tailor activities to what I enjoy and that feel better naturally, which is weight lifting,” he says.\n" +
                                "\n" +
                                "But while people with mesomorph body types may see the most progress after weight and strength-training sessions, it’s important not to forgo other types of exercise.\n" +
                                "\n" +
                                "Do diversify your workouts and include cardio. “If you’ve just been weight lifting, take a day to do body weight exercises and spend a day on cardio to challenge your heart and respiratory system for endurance,” says Katrina Pilkington, a NASM-certified personal trainer based in Sacramento. It’s not a call to run every day, but do focus on your heart (via cardiovascular or aerobic exercise) sometimes rather than just your muscles, she says.\n" +
                                "\n" +
                                "Also get in flexibility or mobility training. “Flexibility is all about recovery and making sure muscles can perform to their optimum ability,” says Pilkington. She favors vibration therapy to release tight muscles (use a power massager, for instance). Research published in the Journal of Clinical & Diagnostic Research found that vibration therapy can be effective for improving muscle recovery, power, strength, flexibility, and reducing post-exercise muscle soreness.\n" +
                                "\n" +
                                "If that’s not available to you (these devices can be an investment), static stretching post-exercise is another good option, says Pilkington.\n" +
                                "\n" +
                                "“If you do not take care of your tendons and muscles, you’ll hit a wall in training and may also get injured,” she says. Try stretches like the quad stretch (where you stand and bring one heel up to your butt), a calf stretch, or lat stretch (facing a table, stretch both arms out straight on the table, then bend forward and push your shoulders down), Pilkington says.\n" +
                                "\n" +
                                "Common Mesomorph Exercise Mistakes — and How to Fix Them\n" +
                                "Skipping cardio If you’re continually in the weight room, you may be missing out on the cardiorespiratory side of a fitness routine. It’s not necessary to go through long bouts of cardio if you find it especially grueling. Instead, consider interval sprints or high intensity interval training (HIIT), which will get your heart rate up but can be done in much shorter periods of time, says Feit.\n" +
                                "Getting stuck in an exercise rut Not enough variety in an exercise routine can be a problem for people of any body type, says Feit. For mesomorphs, it might look like always doing the same weight training routine or the same types of strength workouts. Cross-training with other activities will prevent mental burnout and lower the risk of injury. Broaden your scope of what “counts” as exercise. A long hike with your family — even if casual — can make your legs (and lungs) burn in different ways by forcing your body to recruit a range of muscles, including stabilizer muscles, rather than isolating them at the gym. Similarly, yoga and Pilates may not come naturally to you, but you may realize that an occasional practice makes your body feel really good.\n" +
                                "Not going after your exercise goals Maybe you decide that, in fact, you do want to train for a half or full marathon. Don’t let a boxier frame and more muscle dissuade you from signing up. (You may find that it’s not you, or you could discover you love it.) Never let naysayers tell you what you can and can’t excel at. “Your body type doesn’t define you,” says Feit. “While it might provide some basic guidelines about what will work for you, don’t let that dictate the exercise you pick,” he says.");
                        break;

                    case 5:
                        articles_heading_textview.setText("Can Fitness Trackers and Apps Give Your Exercise Routine a Boost?");
                        articles_textview.setText("Can a wearable fitness tracker or smart phone app really prod you to exercise more — and stick with it? In a new analysis of 28 studies involving 7,454 people, using these popular digital physical-activity aids was linked to users logging an extra 1,850 steps per day compared with non-users (nearly a mile more).\n" +
                                "\n" +
                                "And the fitness app and tracker users were still moving significantly more 13 weeks later.\n" +
                                "\n" +
                                "The wearable trackers and downloadable apps worked best when they provided feedback on progress, enabled users to set personal goals or reminded users to get active via text messages, according to the study, published December 2020 in the British Journal of Sports Medicine.\n" +
                                "\n" +
                                "“Continuously monitoring your progress and receiving feedback from an app or tracker can lead to significant changes in overall physical activity,” says lead researcher Liliana Laranjo, MD, PhD, a research fellow on the faculty of medicine and health at the University of Sydney’s Westmead Applied Research Centre in Australia.\n" +
                                "\n" +
                                "Analysis Focused on New Technology and Healthy Adults\n" +
                                "Dr. Laranjo and the research team analyzed the results of studies conducted between 2014 and 2019 in women and men ages 18 to 65 who used a variety of smartphone apps (including Moves and Accupedo-Pro) or wearable trackers (including Fitbit, Fitbug, Withings Activité Steel, and Jawbone) — and included a control group who did not use devices.\n" +
                                "\n" +
                                "The studies measured the effectiveness of the devices through participants’ self-reports and from data collected directly from the apps and trackers or from research-grade accelerometers that also tracked participants’ activity levels. Some of the measures included: daily step counts, minutes per week of moderate-to-vigorous physical activity, weekly days exercised, minutes per week of total physical activity, or a measure of oxygen uptake by the body during exercise.\n" +
                                "\n" +
                                "This analysis is one of the first to look at the use of newer trackers and apps by healthy people. It focused on newer technology that tracks activity and gives feedback automatically, in contrast to older devices that had to be connected to a computer to upload exercise data, according to the study. Much of the existing work has also been done in people with chronic medical conditions.\n" +
                                "\n" +
                                "Previous research suggests that the older types of devices led to small to moderate increases in activity levels; the aim of this review was to see if the newer technology made a difference, the study authors note.\n" +
                                "\n" +
                                "The devices and apps were the main tools for motivating and measuring physical activity in the studies, but in most of the trials participants also got support, encouragement, and help with goal setting and problem-solving from other participants or from study leaders via meetings, phone calls, emails, or text messages.\n" +
                                "\n" +
                                "After a mean follow-up period of 13 weeks (length of the trials ranged from 2 to 40 weeks), app and tracker users were more active than control groups, based on daily step counts.\n" +
                                "\n" +
                                "Even Small Changes Can Have Meaningful Impact on Health\n" +
                                "The extra 1,850 daily steps could have significant health benefits including lower risk for fatal heart disease, diabetes, and cancer, says study coauthor Bruno Heleno, MD, PhD, an assistant professor at NOVA Medical School at the Universidade Nova da Lisboa in Portugal. “Equally important, [we know from other data that] exercise seems to improve health-related quality of life, improve sleep, [and] reduce anxiety and depression,” Heleno says.\n" +
                                "\n" +
                                "Laranjo and Dr. Heleno say their analysis didn’t single out any one device or app as the most effective at keeping users active. But the analysis did suggest that the trackers and apps were most effective at prompting people to exercise more when they had features that let users personalize their goals and exercise plans and that provided support and encouragement via text messages.\n" +
                                "\n" +
                                "Personalization can help users set easy-to-reach goals and then increase activity with more ambitious goals in the future, Laranjo says. Many people get frustrated and give up if the benchmark is too high (like 10,000 steps per day), when in fact just a small increase from someone’s average can be very beneficial, she explains. “Starting low and progressing slowly, while continuously monitoring the progress and receiving feedback from the app or tracker, can lead to significant changes in overall physical activity throughout time.”\n" +
                                "\n" +
                                "The studies included a wide variety of individuals — inactive young adults, overweight men ages 30 to 65, office workers with desk jobs, medical residents, and sedentary postmenopausal women. And while the researchers didn’t specifically analyze the data by further subgroups (for age, baseline activity level, or other), Heleno says they saw no particular differences that stood out. “We do not have any reason to think the results would be qualitatively different between men and women, young adults and middle aged, or sedentary and already active people,” Heleno says.\n" +
                                "\n" +
                                "The takeaway for healthcare practitioners is that they should have more confidence in recommending fitness trackers and apps to their patients who want to become more physically active because this evidence suggests they work, Heleno says.\n" +
                                "\n" +
                                "With Apps and Trackers, Some Type of Feedback and Accountability Tends to Boost Results\n" +
                                "“These findings are important and show promise for using these technologies to improve physical activity,” says Mitesh S. Patel, MD, an associate professor of medicine and healthcare management at the Perelman School of Medicine and the Wharton School at the University of Pennsylvania in Philadelphia, and director of the Penn Medicine Nudge Unit, which studies and promotes healthy behavior change. Dr. Patel was not involved with this study.\n" +
                                "\n" +
                                "“However, it is important to recognize that the increases in physical activity were not due to using the devices alone, but rather using them with a behavior change program,” he says (referring to the goal-setting features and support from study leaders and other participants). Patel adds that the analysis has limitations, because it looked at studies involving young and middle-aged adults (not older adults) and most tracked the effects of trackers and apps for two to three months, but not longer term.\n" +
                                "\n" +
                                "Patel’s team within the Nudge Unit published a study in February 2020 in the journal JAMA Network Open that compared smartphone apps to wearable trackers in people newly discharged from the hospital. Patel and others found that app users were more likely than tracker users to still be tracking their activity six months later.\n" +
                                "\n" +
                                "“For those interested in using these devices, smartphone apps that track activity are often free and easy to use,” he says. “I’d suggest using one of these first and then deciding if the extra features and tracking available on a wearable will provide additional useful information.”\n" +
                                "\n" +
                                "And whatever app or tracker you choose, Patel says it may work best if you also have accountability and support from a structured program, such as a workplace wellness program or with a supportive friend or family member.\n" +
                                "\n" +
                                "Fitness researcher Michelle Segar, PhD, MPH, director of the Sport, Health, and Activity Research and Policy Center at the University of Michigan in Ann Arbor, and author of No Sweat: How the Simple Science of Motivation Can Bring You a Lifetime of Fitness, suggests consumers new to activity tracking use the findings of this study to inform their choices and look for apps and trackers that let you personalize your goals and get feedback on your progress toward those goals.\n" +
                                "\n" +
                                "To best cultivate lasting motivation — that goes beyond the initial excitement over starting something new and continues to motivate you when the novelty wears off — people need to become very clear about their \"why\" for wanting to make a change, such as feeling happier, having more energy, or feeling more mentally sharp after exercise, says Dr. Segar, who was not involved in the Australian study. Some fitness apps and trackers have features that can help users find and keep tapping into this meaningful motivation, she says.\n" +
                                "\n" +
                                "And she adds, find what motivates you. Just because trackers and apps helped a lot of people in these studies doesn’t mean they worked for everyone, Segar says. “Just like other in-vogue exercise tools, they are not right for everyone.”");
                        break;

                    case 6:
                        articles_heading_textview.setText("What Face Masks Are Best for Exercise?");
                        articles_textview.setText("For several months, health experts around the globe have agreed that wearing a face mask (including homemade ones) can help reduce the spread of the deadly new coronavirus. With COVID-19 infection rates growing across the country, some states and other localities are implementing mask-wearing policies. And recommendations from the Centers for Disease Control and Prevention (CDC) suggest that everyone in the United States should wear face masks or coverings when in public places or around people you don’t live with.\n" +
                                "\n" +
                                "According to that guidance, people should be wearing a face mask while exercising outside their homes. If open, gyms and fitness centers may require patrons to wear a mask.\n" +
                                "\n" +
                                "It's all with good reason: There’s evidence that your risk of spreading virus particles may be greater during exercise, when you’re breathing heavier, making mask-wearing that much more important.\n" +
                                "\n" +
                                "A special report in the April–June 2020 Apunts Sports Medicine performed a new analysis of available data that suggested that when breathing intensifies during exercise (since your body is working harder), the speed and distance you expel respiratory particles that could spread the new coronavirus both increase. Those study authors concluded that keeping more distance between yourself and others while exercising (beyond the six feet that is recommended for the general public) and wearing a mask are potentially really important to help reduce the spread of COVID-19. More research is needed to confirm these findings, however.\n" +
                                "\n" +
                                "Note that wearing a face mask may make exercise feel somewhat more challenging because it can slow the flow of air you're able to breathe in (making your workout potentially feel more intense). They are generally safe for healthy individuals, but if you have a cardiovascular or respiratory condition consider lowering the intensity of your workouts or consulting with your doctor, advises the American Council on Exercise (ACE). And if you feel dizzy, light-headed, or short of breath, slow down or stop exercising until the symptoms go away.\n" +
                                "\n" +
                                "Which types of face mask are best for exercising in?\n" +
                                "\n" +
                                "If your mask soaks up moisture — from sweat, for instance — it will become less effective at preventing the spread of droplets, says Kathryn Melamed, MD, a pulmonologist at UCLA Health in Santa Monica, California. Plus, it can be pretty uncomfortable to breathe when you’re wearing a heavy, soggy face mask. On the other hand, if your mask is too thin, it might not be effective, she says — “some of the droplets can pass through, particularly if you’re breathing heavily, as during exercise.”\n" +
                                "\n" +
                                "Whether you’re shopping among the many brands now selling face masks or DIY-ing it, here’s some advice from Dr. Melamed and others about what to consider.\n" +
                                "\n" +
                                "Make Sure Your Face Mask Fits Well\n" +
                                "First of all, when it comes to choosing a face mask for exercise, make sure it’s a good fit, says Matthew Levy, DO, a senior medical officer and an associate professor of emergency medicine at the Johns Hopkins University School of Medicine in Baltimore. “The mask has to fit well, not fall off while doing an activity, and not require frequent adjustments.”\n" +
                                "\n" +
                                "In general, the mask should be big enough to cover your nose and mouth, yet also comfortable and snug around your cheeks and nose, according to ACE.\n" +
                                "\n" +
                                "“I would recommend people test their masks at home with vigorous movement to ensure they can stay secure without ongoing manipulation or repositioning,” Melamed says. Once it’s on, it should stay put. Some masks have elastic loops that fit over your ears; others tie behind your head. Some masks feature clip attachments that allow you to connect the elastics in the back of your head, keeping the straps off your ears.\n" +
                                "\n" +
                                "And a note about bandannas: They’re better than nothing, but if you have a tighter fitting option, go with it. A study comparing different face mask materials published in the journal Physics of Fluids in June 2020, showed that while bandannas do tend to be thicker than other materials (which is generally more protective), they were the least effective option for preventing the spread of droplets. The reason? Bandanna face coverings are too loose, and allow more droplets to leak out.\n" +
                                "\n" +
                                "When It Comes to Material, Pick Tightly Woven Cottons. More Layers Are Better\n" +
                                "Material matters. All cloth face masks — including surgical ones — are breathable to some extent, according to the American Lung Association (ALA), among other sources. (If you have a lung or heart condition that may make breathing in a face mask challenging during exercise, ACE and ALA recommend consulting your doctor.)\n" +
                                "\n" +
                                "But if your mask is too breathable (or thin), it may not offer enough protection, especially if you’re breathing heavily (like during high-intensity exercise) or talking loudly, Melamed says. Cloth masks made of at least two layers of fabric will be your best bet, as the multiple layers will help buffer more droplets.\n" +
                                "\n" +
                                "“Fabrics such as flannel, muslin, tightly woven cotton, and tea towel fabric have been shown to reduce the transmission of respiratory pathogens,” says Donald Dumford, MD, the medical director for infection prevention at Cleveland Clinic Akron General. According to information from the World Health Organization and Stanford University, polyesters, nylon, rayon, and polypropylene layers can be effective, too.\n" +
                                "\n" +
                                "In the same study published in Physics of Fluids, a stitched mask made of quilting cotton (70 threads per inch) was the most effective at preventing the spread of droplets by distance compared with (in order of effectiveness) a commercial cone mask made of randomly assorted fibers (no thread count listed), a folded cotton handkerchief (55 threads per inch), and a bandanna made of elastic T-shirt material (85 threads per inch).\n" +
                                "\n" +
                                "Be Smarter Than Your Mask: You May Have to Carry a Spare, and You Still Need to Take Other Precautions\n" +
                                "Donning a face mask doesn’t eliminate your risk of catching COVID-19. You still have to practice smart behaviors. The ACE recommends that if you tend to sweat a lot during exercise, you should carry a second mask with you to swap in mid-workout. Moisture can reduce the mask’s effectiveness.\n" +
                                "\n" +
                                "And continue practicing other precautions too, Melamed says. “Masks are meant for use as a strategy to mitigate disease spread, along with other measures such as social distancing, hand-washing, and minimizing face touching.”\n" +
                                "\n" +
                                "Yes, You Can Make Your Own Workout Face Mask\n" +
                                "According to the CDC, you can make your own cloth face masks at home to help prevent the spread of COVID-19 during exercise. They even offer tutorials for both sewn and non-sewn options. Simply find your fabric of choice (the CDC recommends quilting fabric or cotton sheets; T-shirt fabric can work, too), some elastic (rubber bands, string, cloth strips, or hair ties are also good options), a pair of scissors, and any sewing materials you may need. Make sure your mask is snug, yet comfortable; completely covers your nose and mouth; stays in place with ties or ear loops; includes at least two layers of fabric; and allows you to breathe without restriction, according to the CDC.\n" +
                                "\n" +
                                "5 Face Masks Designed for Exercise\n" +
                                "Are there masks specifically designed to be used for exercise? Yes, a few options are out there, but no studies evaluating or comparing their effectiveness have been done at this time.\n" +
                                "\n" +
                                "1. Adidas Face Covers\n" +
                                "These soft, breathable face covers are made of two layers of recycled polyester and elastane. They’re designed for a snug fit — to keep the mask in place while you move — with some stretch in the fabric and elastic ear loops. The masks are machine washable.\n" +
                                "\n" +
                                "2. Athleta Made to Move Mask\n" +
                                "The women’s athletic brand Athleta offers two-layer fabric masks. The outer layer is made of lightweight polyester spandex, while the inner layer is made of breathable polyester mesh. The masks also feature flexible plastic boning in the center of the mask to keep the fabric out of your mouth, and an encased wire that you can adjust to fit securely over your nose bridge.\n" +
                                "\n" +
                                "3. Hanes Wicking Cotton Masks\n" +
                                "These soft, reusable masks are made with three layers of moisture-wicking cotton, as well as cotton-covered rubber band ear loops for a soft, snug fit. The adjustable nosepiece and front panel pleats allow you to personalize your coverage. They’re machine washable and meant to be disposed of after 20 uses.\n" +
                                "\n" +
                                "4. Reebok Face Covers\n" +
                                "These masks provide two layers of soft, breathable fabric (93 percent recycled polyester and 7 percent elastane) that you can wash and reuse again and again. Stretchy ear loops and a snug fit keep the masks securely in place while you walk, run, and cycle. Like the other masks on this list, these offer full nose and mouth coverage. \n" +
                                "\n" +
                                "5. Puma Face Mask\n" +
                                "Nab three layers of protection with these face masks. The combination of nylon and spandex is designed to keep you cool yet covered, while the adjustable straps offer a custom fit. Wash in a garment bag before using, as well as in between uses. A portion of the proceeds from these masks will go toward the UN Foundation’s COVID-19 Solidarity Response Fund for the World Health Organization.");
                        break;

                    case 7:
                        articles_heading_textview.setText("Avoid Running Ruin");
                        articles_textview.setText("Most of us have made the decision at one point or another to take a jog — sometimes successfully — other times not. Sometimes we get out there and run a mile or more with ease and determination; other times we step out of the house just to pick up a light jog around the corner and back, or full-on sprint to the point that we must turn around before we get sick to our stomach.\n" +
                                "\n" +
                                "Whether we run daily or only following our New Year’s resolution, there’s no denying the benefits and natural sense of freedom that a great jog provides. And the fact is, we all have the potential to prepare for and pace ourselves during a run, at least enough to get the sufficient amount of exercise that a jog should provide. If you’ve got a beating heart, working lungs and two good legs (or prosthetics nowadays), then the art of jogging can benefit you. Now all you have to do is perfect your technique, and you’ll be jogging like Forrest Gump in no time.\n" +
                                "\n" +
                                "Feet First\n" +
                                "Wearing the right running shoes is key if you want to enjoy your run and prevent injury.\n" +
                                "\n" +
                                "Do: Go to a qualified running shoe store (or find an employee with footwear knowledge) and get fitted for the right shoes based on what you’re wanting to do. Not all shoes are created equal. Different shoes and brands are better (or worse) for the challenge you’re taking on. Most runners suggest buying a shoe that is slightly longer and wider than your bigger foot.\n" +
                                "\n" +
                                "Don’t: We can’t emphasize this enough: never run in worn-out shoes. Good running shoes should last you 350-450 miles.\n" +
                                "\n" +
                                "Prepare\n" +
                                "The first and foremost important part of getting in a good workout is in the preparation. Decide on your goals and write them down.\n" +
                                "\n" +
                                "Do: Make sure to drink lots of water ahead of time and load up on complex carbs hours before to give you lasting energy for your run. Water lubricates joints, tendons and ligaments as well as helps carry blood efficiently to major organs.\n" +
                                "\n" +
                                "Don’t: Drink energy drinks or coffee to prepare for a run. Caffeine will give you the quick boost you need to get out of bed, but it will wear off quickly once you begin to sweat it out.\n" +
                                "\n" +
                                "Stretch\n" +
                                "Stretching before your run can make the difference between a quick run and a long-distance jog that’ll truly benefit you.\n" +
                                "\n" +
                                "Do: Stretch out well before and after a run — core stretches are essential for keeping side cramps at bay during your run.\n" +
                                "\n" +
                                "Don’t:  Start with static stretches. Utilize dynamic stretches like lunges and side skips to stretch and warm up your muscles simultaneously. Stretching “cold” muscles can cause more harm than good.\n" +
                                "\n" +
                                "Pace\n" +
                                "Pacing yourself can be one of the most difficult parts of jogging; but slow and steady wins the race.\n" +
                                "\n" +
                                "Do: Start with a pace that seems too slow at first. A light jog will allow you to keep running for longer without stopping. Listen to your body. You can run through annoyance, but not through pain.\n" +
                                "\n" +
                                "Don’t: Take off when you first hit the pavement; time your breathing and movement, and don’t speed up until you see the finish line.\n" +
                                "\n" +
                                "Focus\n" +
                                "Your running form can be negatively affected by distractions such as people and your surroundings. Also make sure you stay above bored. Avoid getting caught up in the training-is everything syndrome.\n" +
                                "\n" +
                                "Do: Keep your eyes locked ahead and stay neutral to keep from wearing yourself out early on.\n" +
                                "\n" +
                                "Don’t: Talk, text or turn from the road in front of you; this will affect your breathing and cause you to lose your steady breath and focus.\n" +
                                "\n" +
                                "Breathe\n" +
                                "Keeping a steady flow of breath will enable you to run much farther without cramping up or getting worn-out.\n" +
                                "\n" +
                                "Do:  Pay close attention to your breathing. Focus on breathing in your nose and out your mouth to keep cramps at bay.\n" +
                                "\n" +
                                "Don’t: Focus too hard on inhaling as much oxygen as possible in your mouth; this will cause you to cramp much quicker.\n" +
                                "\n" +
                                "Tune Out\n" +
                                "Although focusing on your goal is important, tuning out what’s around you will help your body decide when you actually need to take a break.\n" +
                                "\n" +
                                "Do: Keep your eyes on the goal and strive for as few distractions as possible.\n" +
                                "\n" +
                                "Don’t: Tune out too much, because being aware of cars and other runners is just as important as the success of your run.\n" +
                                "\n" +
                                "New Roads\n" +
                                "There is only so much binge watching you can do before that show gets a little old. Running is the same. Battling through another run, seeing the same real estate, will get boring and send you back to the couch in no time.\n" +
                                "\n" +
                                "Do: See new parts of town and explore some off-the-beaten-path locations. If your knees can take it, tackle a trail and go off-road.\n" +
                                "\n" +
                                "Don’t: Run with traffic. Always run against it.\n" +
                                "\n" +
                                "Ease Into It\n" +
                                "Sometimes runners get too caught up in the now and increasing what their bodies are capable of too soon which can lead to injury or burn out.\n" +
                                "\n" +
                                "Do: Increase your distance by 10-15 percent a week. Build slowly.\n" +
                                "\n" +
                                "Don’t: It’s easy to get intimidated (or embarrassed) as others pass you or make you seem like a power walker at the mall. Let it go. This isn’t the time to let your ego take over.");
                        break;

                    case 8:
                        articles_heading_textview.setText("7 Quick Stretches for Stress Relief You Can Do Right Now");
                        articles_textview.setText("Take a quick second and lift your arms high above your head. That felt pretty good, right?\n" +
                                "\n" +
                                "For most of us, feeling at least some stress at some point during the day is probably inevitable — whether it’s thanks to too many emails in your inbox, too many appointments on your calendar, too many at-home chores to keep up with, or a problem you have to deal with, like a clogged sink or an illness or injury.\n" +
                                "\n" +
                                "And what ultimately helps us keep stress under control isn’t necessarily eliminating all of those potential stressors that might come up (because that’s probably not possible); it’s a matter of having the right tools and skills to manage it so it doesn’t overwhelm you. Stretching is just one of a number of tools you can use to manage stress.\n" +
                                "\n" +
                                "One of the reasons stretching is so effective for stress is that our (generally) more sedentary lifestyles promote stiffness, which exacerbates that stress in the first place, explains Jessica Matthews, an assistant professor of kinesiology and integrative wellness at Point Loma Nazarene University in San Diego and the author of Stretching to Stay Young. “Restriction in range of motion caused by tight, stiff muscles not only negatively affects how you move when exercising and when going about everyday activities but it also negatively affects how you feel physically and mentally.”\n" +
                                "\n" +
                                "On the other hand, stretching is an accessible way to unwind and de-stress during or after a busy day, says Matthews, who is also a yoga instructor certified by Yoga Alliance, the world's largest nonprofit yoga association that certifies teachers and schools. Stress in your muscles manifests as tightness — and when you relax those muscles, you can tap into your body’s ability to release mental stress, according to Harvard Health Publishing.\n" +
                                "\n" +
                                "“Stretching and movement provide proper circulation, increase oxygen, and release tension in your muscles,” says Kelsey Decker, a personal trainer certified by the National Strength and Conditioning Association and an education coordinator for StretchLab in Orange County, California.\n" +
                                "\n" +
                                "Together, all of these effects help you simmer down, she says. Increasing circulation relaxes muscles, sending mood-elevating blood flow to the brain. A higher oxygen level (a result of breathing deeply through stretches) slows your heart rate and blood pressure. And finally, letting go of the physical tension of a stretch (when you leave the posture) sends the message to your brain to relax.\n" +
                                "\n" +
                                "\n" +
                                "When performing stretches, Matthews recommends holding each for 15 to 30 seconds; repeat each two to four times, per guidelines from the American College of Sports Medicine. Matthews suggests taking a total of five slow, controlled breaths when holding each rep of a stretch, which should be about 15 seconds.\n" +
                                "\n" +
                                "Note: If you experience tingling, numbness, or pain when you try any of the following stretches, or any illness or injury prevents you from doing them safely, skip them or ask your doctor for an appropriate modification.\n" +
                                "\n" +
                                "Here are seven stretches that help your body and mind relax:\n" +
                                "\n" +
                                "1. Child’s Pose\n" +
                                "\n" +
                                "Your lower back is a prime place for the body to hold tension, Decker says. Stretches like this one, which elongates the back, release low back tightness and stiffness. The yoga pose can also promote healthy sleep, according to Harvard Health Publishing.\n" +
                                "How to Do It Kneel on the floor. Bring your feet together and open your knees to create a V shape. Sit back, keeping your butt on or reaching toward your heels, and walk your hands in front of you so that your chest lowers to the ground. Breathe deeply through your diaphragm.\n" +
                                "\n" +
                                "\n" +
                                "2. Seated Spinal Twist\n" +
                                "\n" +
                                "A spinal twist combines a deep breath with a twisting motion, like wringing the stress out of your spine as you would wring water out of a wet towel. “You can easily perform this right in your chair at work for a much-needed break during a busy workday,” says Matthews.\n" +
                                "How to Do It Sit toward the edge of your chair with your feet flat on the floor. Place your right hand at the back of the seat, by the backrest, and place your left hand on your right thigh. Inhale, lengthen your spine, then exhale and rotate your torso to the right, gazing over your right shoulder. Repeat on the other side.\n" +
                                "\n" +
                                "3. Happy Baby\n" +
                                "\n" +
                                "The benefit of this stretch is that it will help open your hips, which is a common reason for a tight back. “We create poor body positions every day from sitting too long,” says Decker. Yoga stretches like these may also be used to help alleviate chronic back pain, according to the Mayo Clinic.\n" +
                                "How to Do It Lying on your back, lift your knees toward your chest. Grab the bottoms of each foot with your hands and pull your knees toward your chest and armpits.\n" +
                                "\n" +
                                "4. Lying Glute Stretch\n" +
                                "\n" +
                                "This stretch is good for putting some movement into your lower back, especially if you’ve been sitting still. You will have to get up and find a spot to lie down. (Remember taking a brief break from whatever you’re doing can help relieve stress, too, Decker says.) What’s more, the stretch releases tight hamstrings. “It helps externally rotate the hip and provide a stretch to the outer glutes to target the lower back,” Decker explains.\n" +
                                "How to Do It Lie on your back and bend your knees so your feet are flat on the floor. Cross your right foot to your left knee, keeping your left leg bent, to create a figure four. Bring your hands behind your right knee and pull both legs toward your chest. Repeat on the other side.\n" +
                                "\n" +
                                "5. Wide-Legged Forward Fold With Chest Expansion\n" +
                                "\n" +
                                "This stretch targets your upper and lower body, says Matthews, making it a perfect do-it-all move. It’s especially great for tight hamstrings (common in walkers and runners), as well as tight chest and shoulder muscles (common if you often sit at a desk typing), she says.\n" +
                                "How to Do It Stand with your feet 3 to 4 feet apart. Softly bend your knees. Hold one end of a small towel in one hand with your palm facing behind you, then reach your opposite hand back to grab the other end of the towel. Inhale and roll your shoulders back and down. Exhale and slowly fold forward (focus on hinging at your hips). Move your arms forward to draw your knuckles toward the ceiling (and downward toward the floor if you can). For more stability, keep your hands at your hips as you bend forward.\n" +
                                "\n" +
                                "6. Chest Opener Stretch\n" +
                                "This is a great at-your-desk stretch when you need a quick release. “This stretch promotes proper posture and releases tension through your chest to maximize oxygen and circulation,” Ducker explains.\n" +
                                "How to Do It Clasp your hands behind your back, squeeze your upper shoulder blades toward each other behind you, and push out through your chest.\n" +
                                "\n" +
                                "7. Rotational Neck Stretch\n" +
                                "\n" +
                                "Reacting to stress by tensing up your neck and scalp muscles can trigger a tension headache, according to the National Institutes of Health. To keep healthy flexion in your neck and let go of tightness, Decker recommends this simple and effective neck stretch, which targets the muscles in the back of your neck.\n" +
                                "How to Do It Bring your chin to your chest and rotate your chin toward an armpit. If you need more of a stretch, Decker suggests placing your hand on the back of your head and pushing your head closer to your armpit. Repeat, rotating your chin to the other armpit.");
                        break;

                    case 9:
                        articles_heading_textview.setText("Everything You Need to Know About Working Out at Home");
                        articles_textview.setText("Working out at home has its benefits: It’s convenient, it’s time-efficient (compared with traveling to a gym or fitness studio), and it’s cost-effective. And, with the current COVID-19 pandemic, quarantines and stay-at-home orders have exercisers more interested in sweating it out at home than ever before.\n" +
                                "\n" +
                                "No matter what your fitness levels, exercise history, or at-home equipment set-up looks like, home workouts can help you meet specific exercise goals (like improving strength or boosting cardiovascular fitness) and can improve boost overall health.\n" +
                                "\n" +
                                "Plus, they’re infinitely customizable. Here are some tips on how to create an effective home workout schedule, what equipment you might need, and how to get started.\n" +
                                "\n" +
                                "First Things First: How to Train at Home Safely\n" +
                                "Exercising at home doesn’t necessarily pose any greater risk of injury and overdoing it than you’d run into training somewhere outside the home. But if you’re working out in an exercise class or with a trainer elsewhere, there may be someone watching you and correcting you if your form is off or you appear to be training in a potentially harmful way. At home, you’re on your own.\n" +
                                "\n" +
                                "Injuries happen when you don’t use proper form or you overstress any one muscle group (or overdo it with any one type of exercise), which can contribute to muscle imbalances and overuse injuries, Prentiss Rhodes, a doctor of chiropractic and manager of live events with the National Academy of Sports Medicine (NASM), who is based in Scottsdale, Arizona.\n" +
                                "\n" +
                                "To keep risks to a minimum, it’s important to dial in and focus just like you would if you were in the gym or working out under the watchful eye of a personal trainer, says Cordelia Carter, MD, orthopedic surgeon and director of the Center for Women’s Sports Health at NYU Langone in New York City.\n" +
                                "\n" +
                                "For instance, before beginning any new exercise, Dr. Carter recommends watching instructional videos from qualified trainers. The YouTube channels of certifying fitness organizations such as the American Council on Exercise, NASM, and National Strength and Conditioning Association are great resources for mastering exercise technique.\n" +
                                "\n" +
                                "Working with an online trainer — a certified expert who can design customized workouts and help you improve your form by watching you and coaching you via video — can be another great move for reducing the risk of injury. Virtual trainers can also help you modify exercises to take into account existing aches, pains, injuries, or other limitations you may have. (Tip: Before reaching out to any online trainers that you find via Google, social media, or YouTube, run their name through the U.S. Registry of Exercise Professionals to verify they are certified by a respected organization.)\n" +
                                "\n" +
                                "One of the most important components of exercising safely at home is creating a training routine that’s right for your unique body and not someone else’s.\n" +
                                "\n" +
                                "Make modifications if you’re following an online workout or class to make the workout appropriate for you, just like an instructor would have you do in a live class. For instance, if you’re new to strength training, substitute plyometric and jumping exercises for nonexplosive variations, recommends Caroline Juster, a corrective exercise specialist and a personal trainer certified by NASM, who is based in Chicago.\n" +
                                "\n" +
                                "If you experience knee pain with lunges, split squats or single-leg glute bridges might be more comfortable for training your quads, she says.\n" +
                                "\n" +
                                "Once you have your program ready, give it your best shot and give it your full attention. “The main reason I see people get injured from at-home training is because they don’t concentrate on what they’re doing,” Rhodes says. Resist the urge to multitask with chores, other at-home tasks, or conversations. “Let your family members know to respect your workout time,” he says. “For example, my daughter knows when I go into my space that she is to let me train.”\n" +
                                "\n" +
                                "To evaluate and constantly improve your form, consider setting up your phone to record you doing a few reps; it’s a great way to check and improve your form from various angles, Carter says.\n" +
                                "\n" +
                                "How to Design an At-Home Workout Routine\n" +
                                "Variety not only keeps things interesting, but when it comes to fitness a variety of types of workouts and muscle groups targeted makes you stronger and helps prevent injury. How much variety do you need? The foundation of any well-rounded workout routine includes both aerobic and strength training. Start with the guidelines for physical activity for Americans.\n" +
                                "\n" +
                                "The Centers for Disease Control and Prevention (CDC) recommends that all adults get at least 150 minutes of moderate-intensity physical activity each week, in addition to two days per week of total-body muscle-strengthening activities. After building a foundation, increasing your total exercise time or intensity comes with even greater health benefits.\n" +
                                "\n" +
                                "Aerobic exercise includes, but isn’t limited to, activities like walking, running, and cycling.\n" +
                                "\n" +
                                "If you're stuck at home and don’t have any cardio equipment at your disposal, a great option to train your body aerobically is to perform various low-intensity exercises back to back with minimal rest, explains Rhodes. Do the exercise for a minute, rest for 30 seconds, and then do it again for up to 15 or 30 minutes. (You can tweak the length of your work and rest bouts based on the exercises you’re performing and how they feel.) This allows you to sustain an elevated heart rate and focus on developing cardiovascular over muscular strengths.\n" +
                                "\n" +
                                "Some bodyweight exercises to try it with include:\n" +
                                "\n" +
                                "Lunges\n" +
                                "Pushups\n" +
                                "Squats\n" +
                                "Planks\n" +
                                "Pullups\n" +
                                "Glute bridges\n" +
                                "For strength training, prioritize squats, lunges, hip hinge exercises (like deadlifts and hip thrusts), pushing exercises (like chest and shoulder presses), and pulling exercises (like rows and pull-ups), Rhodes says. These compound exercises focus on strengthening the human body’s basic movement patterns, so they’ll provide the most benefit to the muscles that tend to get a lot of wear and tear. Plus, all of these movement work multiple muscle groups simultaneously, making them time-effective moves, too.\n" +
                                "\n" +
                                "Whether you’re exercising with dumbbells, resistance bands, or your own bodyweight, to get the most out of a strength workout, it’s important to push your muscles to fatigue — that point when you feel your muscles burning and might only have a couple good-quality reps left. You can either up the intensity by increasing weights and resistance levels if you’ve got the equipment, Juster says. Or you can up the challenge on bodyweight exercises by increasing your reps and sets, slowing down your movements, or trying an advanced exercise variation. (If you usually perform bodyweight squats, you could progress to a single-leg variation, for example.)\n" +
                                "\n" +
                                "And do give yourself a day or two in any week for rest and recovery! Everyone will need to factor a different amount of recovery days into their fitness routine, largely based on how long and how intense your workouts are, Juster says. The harder and longer your workouts, the more time you will need to recover between them. Rest days can range from pure do-nothing days to opportunities to engage in low-intensity exercise like walking, yoga, foam rolling, or stretching.\n" +
                                "\n" +
                                "Balance Trying Out New Workouts and Consistency for the Most Fitness Benefit\n" +
                                "Trying new workouts keeps exercise fun. And for people exercising at home, online workouts — available through streaming websites and apps — are really useful for getting acquainted with new forms of exercise, too.\n" +
                                "\n" +
                                "“Novelty is the sexy side of fitness,” Juster says. “Everyone loves to try new things, and many of us actively scroll Instagram looking for newer, better, and more exciting workouts.”\n" +
                                "\n" +
                                "Performing different types of workouts throughout your weekly routine is important for keeping things interesting, preventing workout ruts, optimizing results (you want to be doing a mix of different types of movement, remember), and preventing injury, Carter adds.\n" +
                                "\n" +
                                "However, don’t let novelty get in the way of your results.\n" +
                                "\n" +
                                "If you are training for a specific goal — like getting stronger at certain exercises or maximizing your body composition (muscle gain or fat loss) pursuits — progressive overload (practicing, getting stronger, and then gradually making your existing workouts harder) is what triggers fitness gains, Juster says.\n" +
                                "\n" +
                                "“To balance consistency and novelty, I recommend repeating the same set of workouts for four to six weeks at a time,” she says. “Then, when training starts to get stale or progress slows, you can switch things up with small progressions.” Examples of such small progressions include: changing your reps and sets, increasing workout intensity, or adding exercise variations. For example, if you’ve done standard squats for a month or longer, you could switch to performing a split squat or overhead squat.\n" +
                                "\n" +
                                "If your training goals are less specific, do switch up your workouts as much as you want — even on a daily basis.\n" +
                                "\n" +
                                "Staying Motivated and Enjoying Your Workouts\n" +
                                "When working out at home, there’s no such thing as gym closures, class cancellations, or inclement weather (if you’re working out inside) to throw off your workout schedule. But there’s also less accountability to show up, because likely only you’ll know if you skip it.\n" +
                                "\n" +
                                "And yes, it’s important to leave some room for flexibility in your workouts for unforeseen conflicts or obstacles. However, the reality is that some days, you may need to expend a bit more mental fortitude to stick with your movement goals and stick to your movement plan than others. So how do you stay dedicated to your at-home training plan that exercise buddy or gym instructor to hold you accountable?\n" +
                                "\n" +
                                "Here are a few tips:\n" +
                                "\n" +
                                "Do forms of exercise that you enjoy. You’re far more likely to stick with workouts that are fun for you, Juster says.\n" +
                                "Keep distractions to a minimum. When exercising, staying mentally engaged — tuning into your body and being conscious about every movement — is a critical component to mental flow, the foundation of the famed “runner’s high,” Rhodes says. Good news: You can experience the high during any workout, but not if your mind’s on other things.\n" +
                                "Keep your exercise intensity at a level that feels good and doable. Try to not push yourself so hard that you feel you need distractions to keep going.\n" +
                                "Block out time for your workouts. Consider scheduling them in your calendar so they don’t get pushed off for later, Juster suggests.\n" +
                                "Give yourself some time before each workout to get in the zone. “Don’t expect to be able to easily shift gears into workout mode immediately after doing another household task,” Juster says. Play some energizing music, drink some water, and eat a small pre-workout snack if you’re running low on energy.\n" +
                                "Do mini-workouts. throughout the day if you have trouble making time for longer workouts. That might mean doing three 10-minute workouts instead of one 30-minute workout, Juster recommends.\n" +
                                "RELATED: Tips to Help You Start Working Out and Stick With It\n" +
                                "\n" +
                                "At-Home Workout Equipment 101\n" +
                                "“Although you can spend a lot of money building a fancy home gym, you can also get a high return on a small investment if you have limited funds or space,” Rhodes says, noting that the only equipment you 100-percent need is yourself.\n" +
                                "\n" +
                                "Investing in equipment, however, can help to fill two gaps that easily pop up in at-home workout routines (types of movement that tougher to do without equipment):\n" +
                                "\n" +
                                "Cardio While streaming aerobics workout videos, doing strength circuits, and dancing around all provide opportunities for improving your cardiovascular health, if running, biking, rowing, or using the elliptical or stair-climber is your cardio method of choice, it could be worth looking into a cardio machine (like a treadmill, exercise bike, or elliptical or rowing machine) that fits your budget and space.\n" +
                                "Pulling Exercises Weights or resistance bands come in handy for training the back and biceps with upper-body pulling movements. After all, while you can easily train your chest and triceps with pushups, training your back and biceps with rows or other pulling movements requires equipment. Dumbbells, kettlebells, and resistance bands are all very versatile, but since resistance bands are incredibly budget- and space-friendly, they can be a great piece of equipment for testing the at-home workout water. “It’s best to buy a set with multiple bands of varying resistance levels because you’ll need different size bands to effectively target different muscles and movements,” Juster says.\n" +
                                "In the end, when it comes to any piece of at-home fitness equipment, Rhodes recommends asking yourself the following questions:\n" +
                                "\n" +
                                "Is it in the budget?\n" +
                                "Do I like using it?\n" +
                                "Would I use this regardless of my current situation?\n" +
                                "Do I have space for it?\n" +
                                "Can I achieve that tool’s function with something else I already have or that would be less costly?\n" +
                                "“If you can answer yes to all of these, then you should buy the piece of equipment,” she says.\n" +
                                "\n" +
                                "If you answered no, but still want to do a workout that requires it, try these smart at-home workout equipment swaps:\n" +
                                "\n" +
                                "Instead of a cardio machine, use a jump rope.\n" +
                                "Instead of 1- to 5-pound weights, use cans of food or books.\n" +
                                "Instead of a heavy weight, use a loaded backpack or bag of pet food.\n" +
                                "Instead of a kettlebell, use a weighted backpack.\n" +
                                "Instead of a yoga block, use a shoebox.\n" +
                                "Instead of a medicine, stability, or BOSU ball, use a pillow.\n" +
                                "Instead of a box or step, use your stairs or a sturdy stool.");
                        break;

                    case 10:
                        articles_heading_textview.setText("Exercise Your Manners");
                        articles_textview.setText("Working out is an investment of both time and money. And it’s not always easy to get to the gym or stay motivated. But as you start to see progress and notice how much better you feel, it can begin to become a lifetime routine.\n" +
                                "\n" +
                                "This can be very important for some people since they use exercise for several reasons such as losing weight, gaining muscle, or even reducing symptoms of harmful disease. You want to get the most out of your time when you can go, but it doesn’t help when the gym is full of annoyances that detract from your workout and make you less than thrilled to come back.\n" +
                                "\n" +
                                "It is already hard enough to fit gym time into your busy schedule that you do not want to encounter any roadblocks while spending a part of your busy day exercising and wearing out your body. From the locker rooms to the equipment, there is an unspoken rule to leave distance if available. For instance, if the gym is practically empty, there’s no need to hop on the treadmill right next to someone who’s already been running.\n" +
                                "\n" +
                                "Most can relate to at least some of these gym pet peeves. If you read through this list and realize you are one of these people, now’s the time to start making some changes.\n" +
                                "\n" +
                                "Excess cellphone use\n" +
                                "As cellphones become more advanced, people become more distracted and glued to the screens of their phones. People feel like they need to be connected 24/7, which can be a problem when it comes to working out. Studies show that people who spend time on their phones in between reps show a decrease in the intensity of their workout. This decrease in intensity leads to a reduced heart rate, which means you are burning less energy.\n" +
                                "\n" +
                                "Few things are more annoying than someone talking on their cellphone. The machines make the room louder than usual to begin with, so people feel the need to scream while they are having a conversation. Others don’t need to hear your life story or drama while trying to relieve stress. If you must take a call during your workout, go to a private and quiet area to have your conversation.\n" +
                                "\n" +
                                "While it’s fine to log your workout, check how many reps and sets you have left, or change a song, texting with your buddies for long bouts of time (especially while someone else is waiting for the equipment) is poor gym etiquette.\n" +
                                "\n" +
                                "When in the gym, put your phone down. You’ll not only reap benefits by ramping up intensity and training harder, but others around you may appreciate it as well.\n" +
                                "\n" +
                                "Not wiping down equipment\n" +
                                "One of the most important rules is to have proper sweat etiquette. Clean the equipment you use after finishing with it so that the next person does not come in contact with your germs. While it may not seem like a big deal to not clean your equipment, it can be a severe issue. It has been shown that free weights at a gym carry 362 times more bacteria than a public toilet seat. Sweat contains a wide assortment of germs and bacteria, leading to the spread of viruses. Tainted gym surfaces can cause you to catch staphylococcus aureus (staph infections), candida (ringworm), and even E. coli. If you forget to bring a towel, use your sweatshirt or paper towels provided by the club.\n" +
                                "Not re-racking weights\n" +
                                "\n" +
                                "It’s so frustrating to walk up to a barbell and find weights left on it. Not only do you have to take the time of re-racking someone else’s sweaty weights, but you may even have trouble carrying the weights.\n" +
                                "\n" +
                                "Hogging equipment\n" +
                                "Whether it be someone accumulating multiple pieces of equipment or sitting on a machine when not using it, hoarding equipment can be very frustrating. Most of the time, you are on a time crunch when at the gym, and it does not help when you are waiting for your turn for a piece of equipment.\n" +
                                "\n" +
                                "If you see someone waiting to use a piece of equipment you’re on, ask them if they want to work in. If you have multiple sets left, try and finish your reps quickly to give them a chance. This becomes especially true when you’re doing supersets on various pieces of equipment.\n" +
                                "\n" +
                                "Unless you hit the gym when it’s dead, don’t spend hours on one machine. This is especially pertinent during peak hours when people might have to wait for machines. A good rule of thumb for cardio equipment is to spend no more than 30 minutes on these machines.\n" +
                                "\n" +
                                "Invading personal space\n" +
                                "Give people their personal space. Do not unnecessarily crowd others. If there are five treadmills, and one is occupied while the other four are available, do not choose the one right next to the occupied machine. If you are waiting for equipment to become available, do not hover directly over the person using the machine. When in the locker room, do not lay all of your belongings out and take up more space than is necessary. It’s also important not to occupy shared space, creating obstacles for your fellow gym-goers. For instance, do not exercise right in front of the racks where all the dumbbells stored.\n" +
                                "\n" +
                                "Excessive grunting\n" +
                                "While grunting can be seen as actual exertion during a workout, it can be seen as obnoxious at times. Although some research says that 10% more force is exerted among athletes who grunt during their exercises, there is a distinction between a powerful grunt and an “I am trying to show off” grunt.  \n" +
                                "\n" +
                                "It’s one thing to let out a little grunt if it helps you get the weight up, but it’s quite another to be shouting just to get attention. Screaming and distracting people from their sessions isn’t fair. Be respectful of others using the gym space.\n" +
                                "\n" +
                                "Offering unsolicited advice\n" +
                                "Having someone abruptly interrupt your workout to give you advice is distracting and humiliating. It is often already uncomfortable for many people to put themselves out there at the gym. Most gyms offer personal training services to their customers. You may have been studying the proper form for deadlifts and the best protein powders, but offering that advice to your neighboring weight lifter is most likely not welcome. Do what works best for you, but leave the advice to professionals.\n" +
                                "\n" +
                                "Training sick\n" +
                                "There might be some truth to sweating out a fever, but when it comes to shared spaces, it’s important to remember that full-blown coughs and sky-rocketing temperatures are not communal. A couple of sniffles are fine, but if you’re blowing your nose between sets, coughing in between reps, or have a fever, stay home and rest. You’re not only delaying your recovery, but you’re also risking getting everyone else in the gym sick as well.");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}