package com.example.nm.Others;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nm.Infor.OfflineInformation;
import com.example.nm.R;

public class DiseaseInformation extends AppCompatActivity {

    //local components
    private TextView crop_name;
    private TextView summary_infor;
    private ImageView main_image;
    private TextView more_infor;
    private Button backButton;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_information);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        crop_name = (TextView) findViewById(R.id.crop_name);
        summary_infor = (TextView) findViewById(R.id.summary_infor);
        main_image = (ImageView) findViewById(R.id.main_image);
        more_infor = (TextView) findViewById(R.id.more_infor);
        //backButton = (Button) findViewById(R.id.back_btn);

        /**initialize the class with the offline data  */
        OfflineInformation offlineInformation = new OfflineInformation();

        /**
         * @data : is used to hold data that is passed from the fragment that hold the disease type  */
        data = getIntent().getStringExtra("TEXT");

        Toast.makeText(this, "result" + data, Toast.LENGTH_SHORT).show();

        /** Accessing disease informationn from an external class from the directory [Info]
         * allows for easy change of disease information data when releasing a new update
         * allows for easy and streamlined update for text images
         * Information is located in the lass OfflineInformation
         * */



        if (data.equals("corn maize cercospora leaf spot gray leaf spot")){
            offlineInformation.corn_cercospora_leaf_spot_gray_leaf_spot(crop_name, summary_infor, main_image, more_infor);
        }
        else if (data.equals("corn maize common rust")){

            offlineInformation.corn_maize_common_rust(crop_name, summary_infor, main_image, more_infor);

        }
        else if (data.equals("corn maize northern leaf blight")){

            offlineInformation.corn_maize_northern_leaf_blight(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("potato early blight")){

            offlineInformation.potato_early_blight(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("potato late blight")){

            offlineInformation.potato_late_blight(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("tomato bacterial spot")){

            offlineInformation.tomato_bacteria_spot(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("tomato early blight")){

            offlineInformation.tomato_early_blight(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("tomato late blight")){

            offlineInformation.tomato_late_blight(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("tomato leaf mold")){

            offlineInformation.tomato_leaf_mold(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("tomato septoria leaf spot")){

            offlineInformation.tomato_septoria_leaf_spot(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("tomato spider mites two spotted spider mite")){

            offlineInformation.tomato_spider_mites_two_spotted_spider_mite(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("tomato target spot")){

            offlineInformation.tomato_target_spot(crop_name, summary_infor, main_image, more_infor);

        }else if (data.equals("tomato yellow leaf curl virus")){

           /** offlineInformation */

        }else if (data.equals("tomato mosaic virus")){

        }
    }
/**
    public void corn_cercospora_leaf_spot_gray_leaf_spot()
    {
        crop_name.setText("GRAY LEAF SPOT");
        summary_infor.setText("Gray leaf spot (GLS) is a common fungal disease caused by the pathogen " +
                "Cercospora zeae-maydis in corn. Disease development is favored by warm temperatures, 80°F or 27 °C; and high humidity," +
                " relative humidity of 90% or higher for 12 hours or more. Cropping systems with reduced- or no-till and/or continuous corn" +
                " are at higher risk for gray leaf spot outbreaks.");
        main_image.setImageResource(R.drawable.glslifecycle);
        more_infor.setText("Gray leaf spot lesions on corn leaves hinder photosynthetic activity, reducing carbohydrates allocated towards grain fill." +
                "The extent to which gray leaf spot damages crop yields can be estimated based on the extent to which leaves are infected relative to grainfill." +
                " This can result in a higher risk of stalk lodging and stalk rots due to a loss of structural integrity.");
    }

    public void corn_maize_common_rust(){
        crop_name.setText("COMMON RUST");
        summary_infor.setText("It is a Fungal disease caused by Puccinia sorghi pathogen. Favored by moist, cool conditions (temps in the 60s and 70s) ");
        main_image.setImageResource(R.drawable.common_rust_early_lesions);
        more_infor.setText("The use of resistant hybrids is the primary management strategy for the control of common rust." +
                "Timely planting of corn early during the growing season may help to avoid high inoculum levels or " +
                "environmental conditions that would promote disease development.\n SYMPTOMS \n Symptoms of common " +
                "rust often appear after silking. Small, round to elongate brown pustules form on both leaf surfaces and other " +
                "above ground parts of the plant. As the pustules mature they become brown to black.If disease" +
                " is severe, the leaves may yellow and die early.");
    }

    public void corn_maize_northern_leaf_blight(){
        crop_name.setText("NORTHERN LEAF BLIGHT");
        summary_infor.setText("Northern corn leaf blight starts as pale-gray-green, elliptical or cigar-shaped lesions. These can expand to reach > 6”and as they mature, the lesion color becomes tan to dirty gray with dark zones. Unlike gray leaf spot, lesions of northern corn leaf blight are not restricted by leaf veins. The distinct symptom of northern corn leaf blight is the elliptical cigar shape. However this symptom can be confused with Goss’s wilt except that northern corn leaf blight lesion lacks black freckles.");
        main_image.setImageResource(R.drawable.common_rust_early_lesions);
        more_infor.setText("The use of resistant hybrids is the primary management strategy for the control of common rust." +
                "Timely planting of corn early during the growing season may help to avoid high inoculum levels or " +
                "environmental conditions that would promote disease development.\n SYMPTOMS\n Symptoms of common " +
                "rust often appear after silking. Small, round to elongate brown pustules form on both leaf surfaces and other " +
                "above ground parts of the plant. As the pustules mature they become brown to black.If disease" +
                " is severe, the leaves may yellow and die early.");
    }
    //............................................................................................................................................................................................
    public void potato_early_blight(){
        crop_name.setText("EARLY BLIGHT");
        summary_infor.setText("Early blight (EB) is a disease of potato caused by the fungus Alternaria solani. It is found wherever potatoes are grown." +
                "The disease primarily affects leaves and stems, but under favorable weather conditions, and if left uncontrolled," +
                " can result in considerable defoliation and enhance the chance for tuber infection.");
        main_image.setImageResource(R.drawable.potato_early_blight);
        more_infor.setText("The following measures will help prevent the occurrence of serious EB outbreaks, " +
                "(1) Plant only diseasefree, certified seed. (2) Follow a complete and regular foliar fungicide spray " +
                "program. (3) Practice good killing techniques to lessen tuber infections. (4) Allow tubers to mature" +
                " before digging, dig when vines are dry, not wet, and avoid excessive wounding of potatoes during " +
                "harvesting and handling. (5) Plow underall plant debris and volunteer potatoes after harvest. " +
                "(6) Avoid replanting potatoes (and tomatoes or eggplants) in the affected fields for at least 2 years" +
                " if severe outbreaks have been experienced. (7) Although no cultivar is immune to EB, several cultivars" +
                " are moderately resistant and should be planted if blight is a continuing problem.");
    }

    public void potato_late_blight(){
        crop_name.setText("LATE BLIGHT");
        summary_infor.setText("Late blight, also called potato blight, disease of potato and tomato plants that is " +
                "caused by the water mold Phytophthora infestans. The disease occurs in humid regions with " +
                "temperatures ranging between 4 and 29 °C (40 and 80 °F). Hot dry weather checks its spread. Potato " +
                "or tomato plants that are infected may rot within two weeks.");
        main_image.setImageResource(R.drawable.potato_late_blight);
        more_infor.setText("The disease can be managed with a timely application of fungicide, though epidemics can " +
                "occur rapidly once crops are infected. Given that the oospores have thickened walls and are able" +
                " to persist in the soil for several seasons, the disease can be difficult to eradicate. Resistant" +
                " tomato and potato varieties have been developed");
    }
    //............................................................................................................................................................................................

    public void tomato_bacteria_spot(){
        crop_name.setText("BACTERIA SPOT");
        summary_infor.setText("Bacterial spot can be a devastating disease when the weather is warm and humid.The disease " +
                "can affect all above-ground parts of tomato and pepper plants: stems, petioles, leaves, and fruits.\n" +
                "Fruit spots commonly result in unmarketable fruit, not only for fresh market but also for processing " +
                "because the spots make the fruit difficult to peel.");
        main_image.setImageResource(R.drawable.potato_late_blight);
        more_infor.setText("SIGNS AND SYMPTOMS : Tomato leaves have small (<1/8 inch), brown, circular spots surrounded by a yellow halo.\n" +
                "The center of the leaf spots often falls out resulting in small holes.\n" +
                "Pepper leaves have small (<1/8 inch), brown, circular spots that do not have a yellow halo and centers do not fall out.\n" +
                "Small, brown, circular spots may also occur on stems and the fruit calyx.\n" +
                "Fruit spots are ¼ inch, slightly raised, brown and scabby.\n" +
                "Tomato fruit often have a waxy white halo surrounding the fruit spot.\n" +
                "Pepper fruit spots often occur on the stem-end of the fruit.\n" +
                "Spots occur on green and red fruit but do not result in rot.");
    }

    public void tomato_early_blight(){
        crop_name.setText("EARLY BLIGHT");
        summary_infor.setText("Early blight is one of the most common tomato diseases, occurring nearly every season wherever tomatoes are grown.\n" +
                "It affects leaves, fruits and stems and can be severely yield limiting when susceptible cultivars are used and weather is favorable.\n" +
                "Severe defoliation can occur and result in sunscald on the fruit.\n" +
                "Early blight is common in both field and high tunnel tomato production in Minnesota.");
        main_image.setImageResource(R.drawable.potato_late_blight);
        more_infor.setText("SIGNS AND SYMPTOMS : Leaves\n" +
                "Initially, small dark spots form on older foliage near the ground.\n" +
                "\n" +
                "Leaf spots are round, brown and can grow up to half inch in diameter.\n" +
                "Larger spots have target-like concentric rings. The tissue around spots often turns yellow.\n" +
                "Severely infected leaves turn brown and fall off, or dead, dried leaves may cling to the stem." +
                "Stem " +
                "Seedling stems are infected at or just above the soil line. The stem turns brown, sunken and dry (collar rot).\n" +
                "If the infection girdles the stem, the seedling wilts and dies.\n" +
                "Stem infections on older plants are oval to irregular, dry brown areas with dark brown concentric rings." +
                "Fruit\n" +
                "Fruit can be infected at any stage of maturity.\n" +
                "Fruit spots are leathery and black, with raised concentric ridges. They generally occur near the stem.\n" +
                "Infected fruit may drop from the plant. " +
                "Environment\n" +
                "Disease develops at moderate to warm (59 to 80 F) temperatures; 82 to 86 F optimum\n" +
                "Rainy weather or heavy dew, 90% humidity or greater");
    }

    public void tomato_late_blight(){
        crop_name.setText("LATE BLIGHT");
        summary_infor.setText("Late blight is a potentially devastating disease of tomato and potato, infecting leaves, stems and fruits of tomato plants.\n" +
                "The disease spreads quickly in fields and can result in total crop failure if untreated.\n" +
                "Late blight of potato was responsible for the Irish potato famine of the late 1840s.");
        main_image.setImageResource(R.drawable.potato_late_blight);
        more_infor.setText("SIGNS AND SYMPTOMS : Leaves have large, dark brown blotches with a green gray edge; not confined by major leaf veins.\n" +
                "Infections progress through leaflets and petioles, resulting in large sections of dry brown foliage.\n" +
                "Stem infections are firm and dark brown with a rounded edge.\n" +
                "Firm, dark brown, circular spots grow to cover large parts of fruits. Spots may become mushy as secondary bacteria invade.\n" +
                "In high humidity, thin powdery white fungal growth appears on infected leaves, fruit and stems. In cool, wet weather, entire fields " +
                "turn brown and wilted as if hit by frost." +
                "Environment\n" +
                "Spreads most in cool (60°F to 70°F), damp weather.\n" +
                "Prolonged hot dry days can halt pathogen spread.");
    }

    public void tomato_leaf_mold(){
        crop_name.setText("LEAF MOLD");
        summary_infor.setText("Leaf mold is not normally a problem in field-grown tomatoes in northern climates. \n" +
                "It can cause losses in tomatoes grown in greenhouses or high tunnels due to the higher humidity found in these environments.\n" +
                "Foliage is often the only part of the plant infected and will cause infected leaves to wither and die, indirectly affecting yield.\n" +
                "In severe cases, blossoms and fruit can also be infected, directly reducing yield.");
        main_image.setImageResource(R.drawable.potato_late_blight);
        more_infor.setText("SIGNS AND SYMPTOMS : The oldest leaves are infected first.\n" +
                "Pale greenish-yellow spots, usually less than 1/4 inch, with no definite margins, form on upper sides of leaves.\n" +
                "Olive-green to brown velvety mold forms on the lower leaf surface below leaf spots.Infected blossoms turn black and fall off.\n" +
                "Fruit infections start as a smooth black irregular area on the stem end of the fruit. As the disease progresses, " +
                "the infected area becomes sunken, dry and leathery." +
                "Environment\n" +
                "Optimal growth is at relative humidity greater than 85%.\n" +
                "Optimal temperature is between 71 °F and 75 °F, but disease can occur at temperatures as low as 50 °F and as high as 90 °F.");
    }

    public void tomato_septoria_leaf_spot(){
        crop_name.setText("SEPTORIA LEAF SPOT");
        summary_infor.setText("Septoria leaf spot, also called Septoria blight, is a very common disease of tomatoes. " +
                "It is caused by a fungus (Septoria lycopersici) and can affect tomatoes and other plants in the Solanaceae family, " +
                "especially potatoes and eggplant, just about anywhere in the world. Although Septoria leaf spot is not necessarily " +
                "fatal for your tomato plants, it spreads rapidly and can quickly defoliate and weaken the plants, " +
                "rendering them unable to bear fruit to maturity.");
        main_image.setImageResource(R.drawable.potato_late_blight);
        more_infor.setText("SIGNS AND SYMPTOMS : Septoria leaf spots start off somewhat circular and first appear on the undersides of older leaves, " +
                "at the bottom of the plant. They are small, 1/16 to 1/8 inches (1.6 to 3.2 millimeters) in diameter, with a dark brown margin " +
                "and lighter gray or tan centers. As the disease develops, the spots will get larger and may merge together. " +
                "If you view them through a magnifying lens you may see the fruiting bodies of the fungus, which look like dark brown pimples. " +
                "This is one of the symptoms that distinguish Septoria leaf spot from other leaf spotting diseases." +
                "How to Treat Septoria Leaf Spot" +
                "Removing infected leaves.  Remove infected leaves immediately, and be sure to wash your hands thoroughly before working with uninfected plants.\n" +
                "Consider organic fungicide options. Fungicides containing either copper or potassium bicarbonate will help " +
                "prevent the spreading of the disease. Begin spraying as soon as the first symptoms appear and follow the " +
                "label directions for continued management.\n" +
                "Consider chemical fungicides. While chemical options are not ideal, they may be the only option " +
                "for controlling advanced infections. One of the least toxic and most effective is chlorothalonil (sold under the names Fungonil and Daconil).");
    }


    public void tomato_spider_mites_two_spotted_spider_mite(){
        crop_name.setText("TWO SPOTTED SPIDER MITES");
        summary_infor.setText("Two‑spotted spider mites are occasional pests that can cause serious damage to some vegetable crops " +
                "during hot dry weather. Mites can injure tomatoes, beans, muskmelons, watermelons, and sweet corn. " +
                "Extended periods of hot, dry weather favors mite buildups. Infestations usually first occur at " +
                "the edge of a field, typically near rank weed growth or dirt roads.");
        main_image.setImageResource(R.drawable.potato_late_blight);
        more_infor.setText("SIGNS AND SYMPTOMS : Generally, mites feed on the undersides of leaves. " +
                "They use their sucking mouthparts to remove sap from plants, giving the upper leaf surface a speckled or mottled appearance. " +
                "Leaves of mite-infested plants may turn yellow and dry up, and plants may lose vigor and die when infestations are severe. " +
                "The undersides of affected leaves appear tan or yellow and have a crusty texture. " +
                "Heavy infestations of the two‑spotted spider mite produce fine webbing that may cover the entire plant. " +
                "Mites are identified by shaking symptomatic leaves onto a sheet of white paper or by observing infected leaf areas with a hand lens. " +
                "In hot dry weather, mites can cause plants to drop leaves in a few weeks. Fruit from severely infested " +
                "plants are often unmarketable because defoliated plants tend to yield small, poor quality fruit.");
    }

    public void tomato_target_spot(){
        crop_name.setText("TARGET SPOT");
        summary_infor.setText("Symptoms appear on all aboveground parts of the plant.\n" +
                "Foliar lesions begin as small, pinpoint, water-soaked\n" +
                "spots on the upper surface. Gradually these increase\n" +
                "in size (up to 2 cm diameter), becoming circular,\n" +
                "frequently ringed, and pale brown with conspicuous\n" +
                "yellow halos. The lesions will coalesce leading to\n" +
                "blighting of foliage. The subsequent premature\n" +
                "defoliation affects fruit quality and yield.\n" +
                "The lesions on stems and petioles are brown and\n" +
                "oblong. These increase in size and may girdle petioles\n" +
                "and stems leading to collapse of the leaflets.");
        main_image.setImageResource(R.drawable.potato_late_blight);
        more_infor.setText("SIGNS AND SYMPTOMS : In the early stages of disease development,\n" +
                "symptoms of target spot may be confused with those\n" +
                "of bacterial spot (Xanthomonas campestris pv.\n" +
                "vesicatoria) and early blight (Alternaria solani).");
    }
*/
}