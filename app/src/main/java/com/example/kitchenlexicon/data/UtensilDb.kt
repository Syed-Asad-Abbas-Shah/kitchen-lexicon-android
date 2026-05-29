package com.example.kitchenlexicon.data

object UtensilDb {
    val utensils: List<Utensil> = listOf(
        Utensil(
            id = "chefs-knife",
            name = "Chef's Knife",
            phonetic = "/ʃɛfs naɪf/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Carbon Steel", "Wood", "Composite"),
            altNames = listOf("Cook's Knife", "French Knife"),
            useCase = "The primary cutting tool in the kitchen. Its broad blade and curved edge allow for a smooth rocking motion to slice, dice, and mince vegetables and meats efficiently.",
            funFact = "A full-tang chef's knife means the metal blade extends all the way to the butt of the handle, offering outstanding strength, balance, and leverage.",
            anatomy = listOf(
                AnatomyPart("Point (Tip)", "The front edge used for small, precise detail slicing.", 94f, 48f),
                AnatomyPart("Spine", "The thick, unsharpened top edge of the blade that provides structural rigidity.", 60f, 43f),
                AnatomyPart("Cutting Edge", "The razor-sharp bottom edge used for primary chopping and slicing.", 60f, 60f),
                AnatomyPart("Bolster", "The thick collar between the blade and handle providing support, balance, and hand protection.", 23.5f, 51f),
                AnatomyPart("Handle Tang", "The steel extension inside the wood handle providing structural durability.", 13f, 47f),
                AnatomyPart("Rivets", "Solid metal pins that lock the wooden handles permanently onto the steel tang.", 6f, 51f)
            )
        ),
        Utensil(
            id = "paring-knife",
            name = "Paring Knife",
            phonetic = "/ˈpɛər.ɪŋ naɪf/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Ceramic", "Plastic"),
            altNames = listOf("Peeling Knife"),
            useCase = "A small, lightweight knife with a short blade. Excels at tasks done 'in the air' without a cutting board, such as peeling apples, coring tomatoes, and trimming herbs.",
            funFact = "Paring knives are named after 'paring', which means to strip or cut off the outer skin or surface of something."
        ),
        Utensil(
            id = "bread-knife",
            name = "Bread Knife",
            phonetic = "/brɛd naɪf/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Wood", "Composite"),
            altNames = listOf("Serrated Utility Knife"),
            useCase = "A long knife featuring deep serrations on the blade. The jagged edge acts like a saw to cut cleanly through thick bread crusts or delicate cakes without flattening them.",
            funFact = "A bread knife should never be used to chop veggies; the serrated teeth will tear the fibers instead of slicing them clean."
        ),
        Utensil(
            id = "peeler",
            name = "Vegetable Peeler",
            phonetic = "/ˈvɛdʒ.tə.bəl ˈpiː.lər/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Plastic"),
            altNames = listOf("Y-Peeler", "Swivel Peeler"),
            useCase = "A slotted blade attached to a handle. Perfect for quickly scraping away outer skin from root vegetables, cucumber, or hard fruits.",
            funFact = "The Y-peeler is favored by professional chefs because its ergonomic shape allows peeling towards you or away from you with equal comfort."
        ),
        Utensil(
            id = "box-grater",
            name = "Box Grater",
            phonetic = "/bɒks ˈɡreɪ.tər/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Rubber"),
            altNames = listOf("Cheese Grater", "Shredder"),
            useCase = "A four-sided upright metal cylinder with various hole sizes. Used for shredding cheese, grating chocolate or hard spices, and slicing vegetables like cucumbers.",
            funFact = "Shredding your own blocks of cheese using a box grater avoids the anti-clumping wood cellulose powder added to pre-shredded cheese bags."
        ),
        Utensil(
            id = "kitchen-shears",
            name = "Kitchen Shears",
            phonetic = "/ˈkɪtʃ.ən ʃɪərz/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Plastic/Rubber"),
            altNames = listOf("Kitchen Scissors"),
            useCase = "Heavy-duty scissors specifically built for culinary prep, such as spatchcocking poultry, cutting herbs, snipping bread dough, or snapping lobster shells.",
            funFact = "Top-tier kitchen shears disassemble at the central pivot screw to permit deep, sanitary cleaning of food residue from between the blades."
        ),
        Utensil(
            id = "cutting-board",
            name = "Cutting Board",
            phonetic = "/ˈkʌt.ɪŋ bɔːd/",
            category = "cutting",
            materials = listOf("Wood", "Bamboo", "Plastic"),
            altNames = listOf("Chopping Board"),
            useCase = "A flat board that protects countertops and maintains blade sharpness while cutting, chopping, or carving food ingredients.",
            funFact = "High-quality maple wood boards naturally possess antimicrobial qualities that can neutralize micro-organisms over time."
        ),
        Utensil(
            id = "garlic-press",
            name = "Garlic Press",
            phonetic = "/ˈɡɑː.lɪk prɛs/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Aluminum"),
            altNames = listOf("Garlic Crusher"),
            useCase = "Forces whole peeled or unpeeled garlic cloves through a grid of tiny holes to immediately mash them into a fine paste.",
            funFact = "A garlic press extracts a much stronger, punchier flavor profile because it breaks open more micro garlic cells than fine hand-mincing."
        ),
        Utensil(
            id = "mortar-pestle",
            name = "Mortar and Pestle",
            phonetic = "/ˈmɔː.tər ænd ˈpɛs.əl/",
            category = "cutting",
            materials = listOf("Granite", "Marble", "Ceramic", "Wood"),
            altNames = listOf("Crusher bowl"),
            useCase = "A heavy stone bowl (mortar) paired with a grinding club (pestle). Perfect for crushing whole spices, grinding garlic, or making traditional pesto.",
            funFact = "Pounding garlic and herbs releases fragrant essential oils that cutting with sharp steel blades can never replicate."
        ),
        Utensil(
            id = "mandoline",
            name = "Mandoline",
            phonetic = "/ˌmæn.dəlˈiːn/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Plastic", "Wood"),
            altNames = listOf("Slicing Board"),
            useCase = "A flat board with a sharp, adjustable blade built in. Ingredients are slid across the board to create super thin, consistent slices.",
            funFact = "You must always use the safety food guard (holder) with a mandoline; it is notorious in home kitchens for finger injuries."
        ),
        Utensil(
            id = "apple-corer",
            name = "Apple Corer",
            phonetic = "/ˈæp.əl ˈkɔː.rər/",
            category = "cutting",
            materials = listOf("Stainless Steel", "Plastic"),
            altNames = listOf("Fruit Corer"),
            useCase = "A cylindrical metal shaft with a circular serrated edge at the bottom, used to punch through apples or pears to remove the seed core cleanly.",
            funFact = "Using an apple corer before baking whole apples makes it easy to stuff the hollow center with cinnamon, butter, and brown sugar."
        ),
        Utensil(
            id = "whisk",
            name = "Wire Whisk",
            phonetic = "/waɪər wɪsk/",
            category = "stirring",
            materials = listOf("Stainless Steel", "Silicone"),
            altNames = listOf("Balloon Whisk"),
            useCase = "A cluster of overlapping wire loops used to incorporate air into liquid ingredients, ideal for whipping cream, beating egg whites, and emulsifying dressings.",
            funFact = "The balloon shape is designed specifically to capture air pockets as you whip, making eggs fluffier.",
            anatomy = listOf(
                AnatomyPart("Hanging Loop", "The loop at the base of the handle, used for wall storage.", 50f, 90f),
                AnatomyPart("Ergonomic Handle", "Provides a comfortable grip for high-speed wrist actions.", 50f, 72f),
                AnatomyPart("Collar (Cap)", "Seals the wire inserts to prevent water from entering the handle during washing.", 50f, 52f),
                AnatomyPart("Outer Balloon Wires", "Provides structural bounce and aerates large batches of liquids.", 26f, 22f),
                AnatomyPart("Inner Whipping Wires", "Adds resistance to break up egg whites and create emulsifications rapidly.", 41f, 28f)
            )
        ),
        Utensil(
            id = "spatula",
            name = "Spatula (Turner)",
            phonetic = "/ˈspætʃ.jə.lə/",
            category = "stirring",
            materials = listOf("Stainless Steel", "Silicone", "Wood", "Plastic"),
            altNames = listOf("Fish Turner", "Flipper"),
            useCase = "A flat, broad utensil used for lifting, turning, flipping, and sliding under cooked food items on hot skillets or griddles.",
            funFact = "Serrated fish spatulas are exceptionally thin and flexible, allowing them to slide beneath fragile fish skin without damage."
        ),
        Utensil(
            id = "silicone-spatula",
            name = "Silicone Spatula",
            phonetic = "/ˈsɪl.ɪ.kəʊn ˈspætʃ.jə.lə/",
            category = "stirring",
            materials = listOf("Silicone", "Plastic", "Wood"),
            altNames = listOf("Scraper", "Rubber Spatula"),
            useCase = "A flexible, rubbery scraper blade attached to a handle. Perfect for folding baking ingredients and scraping bowls 100% clean.",
            funFact = "Silicone spatulas are highly heat resistant up to 500°F (260°C), meaning you can stir molten caramel directly without melting."
        ),
        Utensil(
            id = "tongs",
            name = "Kitchen Tongs",
            phonetic = "/kɪtʃ.ən tɒŋz/",
            category = "stirring",
            materials = listOf("Stainless Steel", "Silicone"),
            altNames = listOf("Utility Tongs"),
            useCase = "Spring-loaded metal pincers used for grabbing, flipping, and holding hot foods at a distance, such as turning steak in a skillet.",
            funFact = "Chefs jokingly refer to click-clacking tongs together twice upon picking them up as 'calibrating' the tool."
        ),
        Utensil(
            id = "ladle",
            name = "Soup Ladle",
            phonetic = "/ˈleɪ.dəl/",
            category = "stirring",
            materials = listOf("Stainless Steel", "Wood", "Silicone"),
            altNames = listOf("Scooping Spoon"),
            useCase = "A long-handled spoon with a large, deep bowl. Designed for scooping and pouring soup, stocks, chili, and other high-volume liquids.",
            funFact = "A high-quality soup ladle features a hooked end on the handle, preventing it from slipping into deep stockpots."
        ),
        Utensil(
            id = "wooden-spoon",
            name = "Wooden Spoon",
            phonetic = "/wʊd.ən spuːn/",
            category = "stirring",
            materials = listOf("Beechwood", "Maple", "Bamboo"),
            altNames = listOf("Stirring Spoon"),
            useCase = "A traditional wooden mixing tool. It is gentle on non-stick pans, doesn't conduct high heat, and won't chemically react with acidic ingredients.",
            funFact = "Many cooks believe a wooden spoon absorbs generations of spices, lending a magical depth of flavor to legacy family stews."
        ),
        Utensil(
            id = "slotted-spoon",
            name = "Slotted Spoon",
            phonetic = "/ˈslɒt.ɪd spuːn/",
            category = "stirring",
            materials = listOf("Stainless Steel", "Silicone", "Plastic"),
            altNames = listOf("Sieve Spoon"),
            useCase = "A large spoon with narrow slots or holes in the bowl. Allows liquids to drain away while holding solid items like beans or vegetables.",
            funFact = "A slotted spoon is the ultimate tool for retrieving poached eggs out of boiling vinegar water."
        ),
        Utensil(
            id = "pasta-server",
            name = "Pasta Server",
            phonetic = "/ˈpæs.tə ˈsɜː.vər/",
            category = "stirring",
            materials = listOf("Plastic", "Stainless Steel", "Silicone"),
            altNames = listOf("Spaghetti Server", "Pasta Claw"),
            useCase = "A deep scoop featuring large teeth/prongs along the rim and a hole in the center. Grabs slippery spaghetti strands while draining liquid back into the pot.",
            funFact = "The hole in the middle of a plastic pasta server is exactly sized to measure one single portion of dry uncooked spaghetti."
        ),
        Utensil(
            id = "spider-skimmer",
            name = "Spider Skimmer",
            phonetic = "/ˈspaɪ.dər ˈskɪm.ər/",
            category = "stirring",
            materials = listOf("Stainless Steel", "Bamboo", "Wood"),
            altNames = listOf("Wire Skimmer", "Spider Strainer"),
            useCase = "A wide, flat wire mesh basket attached to a long handle. Excellent for scooping delicate dumplings, donuts, or tempura out of hot frying oil.",
            funFact = "Its name is inspired by the hand-woven concentric wire webs that closely resemble a spider's web."
        ),
        Utensil(
            id = "basting-brush",
            name = "Basting Brush",
            phonetic = "/ˈbeɪ.stɪŋ brʌʃ/",
            category = "stirring",
            materials = listOf("Silicone", "Natural Bristles", "Wood"),
            altNames = listOf("Pastry Brush"),
            useCase = "Used to brush butter, oil, glazes, marinades, or sauces onto foods before and during baking or roasting.",
            funFact = "Silicone bristles are far easier to clean and sterilize compared to traditional boar-hair bristles, which tend to clump."
        ),
        Utensil(
            id = "potato-masher",
            name = "Potato Masher",
            phonetic = "/pəˈteɪ.təʊ ˈmæʃ.ər/",
            category = "stirring",
            materials = listOf("Stainless Steel", "Wood", "Plastic"),
            altNames = listOf("Veggie Masher"),
            useCase = "An upright handle connected to a heavy, zig-zag metal plate. Used by pressing down onto soft boiled root veggies to mash them fine.",
            funFact = "Zig-zag wire mashers produce fluffier potatoes because they don't break open starch cells as heavily as flat disc models."
        ),
        Utensil(
            id = "rolling-pin",
            name = "Rolling Pin",
            phonetic = "/ˈrəʊ.lɪŋ pɪn/",
            category = "baking",
            materials = listOf("Wood", "Marble", "Silicone"),
            altNames = listOf("Dough Roller"),
            useCase = "A heavy, long cylinder rolled over dough to flatten it to a uniform, precise thickness for pie crusts, pastries, and cookie sheets.",
            funFact = "French-style rolling pins have tapered ends without spinning bearings, granting baker hands superior tactile feedback on dough thickness."
        ),
        Utensil(
            id = "pastry-cutter",
            name = "Pastry Cutter",
            phonetic = "/ˈpeɪ.stri ˈkʌt.ər/",
            category = "baking",
            materials = listOf("Stainless Steel", "Wood"),
            altNames = listOf("Pastry Blender", "Dough Blender"),
            useCase = "A handle connected to several parallel, curved steel wires. Used to cut cold butter into dry flour to make flaky pie crusts.",
            funFact = "Keeping the butter cold is the secret to flaky pastry. Hands melt butter, but a cold metal pastry cutter keeps it solid."
        ),
        Utensil(
            id = "dough-scraper",
            name = "Dough Scraper",
            phonetic = "/dəʊ ˈskreɪ.pər/",
            category = "baking",
            materials = listOf("Stainless Steel", "Plastic", "Wood"),
            altNames = listOf("Bench Knife", "Bench Scraper"),
            useCase = "A flat rectangular steel sheet with a plastic or wood grip on one long edge. Used to divide dough portions and scrape flour clean off countertops.",
            funFact = "A dough scraper is incredibly handy for scooping up massive piles of chopped garlic or herbs from cutting board to frying pan."
        ),
        Utensil(
            id = "sifter",
            name = "Flour Sifter",
            phonetic = "/ˈflaʊ.ər ˈsɪf.tər/",
            category = "baking",
            materials = listOf("Stainless Steel", "Plastic"),
            altNames = listOf("Sieve cup"),
            useCase = "A steel cup with a fine wire mesh bottom and a hand crank/squeeze trigger. Aerates flour and filters out clumps for uniform baking layers.",
            funFact = "Sifting flour with cocoa powder or baking soda spreads dry leaveners perfectly through cake flour without dark spots."
        ),
        Utensil(
            id = "piping-bag",
            name = "Piping Bag",
            phonetic = "/ˈpaɪ.pɪŋ bæɡ/",
            category = "baking",
            materials = listOf("Plastic", "Canvas", "Silicone"),
            altNames = listOf("Decorating Bag", "Pastry Bag"),
            useCase = "A cone-shaped bag with a metal decorative tip. Squeezed to extrude frosting, whipped cream, or soft dough in intricate floral patterns.",
            funFact = "The metal nozzles at the tip of piping bags are called 'coupler tips' and permit easy swapping of star patterns while icing."
        ),
        Utensil(
            id = "mixing-bowls",
            name = "Mixing Bowls",
            phonetic = "/ˈmɪk.sɪŋ bəʊlz/",
            category = "baking",
            materials = listOf("Stainless Steel", "Glass", "Ceramic"),
            altNames = listOf("Prep Bowls"),
            useCase = "Deep, nested bowls used for combining ingredients, mixing doughs, whisking dressings, and storing prepped food.",
            funFact = "Metal stainless-steel mixing bowls are highly favored in pastry work because they chill rapidly for whipping cream over ice."
        ),
        Utensil(
            id = "measuring-cups",
            name = "Measuring Cups",
            phonetic = "/ˈmɛʒ.ər.ɪŋ kʌps/",
            category = "measuring",
            materials = listOf("Stainless Steel", "Plastic"),
            altNames = listOf("Dry Measuring Cups"),
            useCase = "Standardized cups used for measuring precise volume weights of dry ingredients like flour, sugar, and cocoa powder.",
            funFact = "Always scoop flour and sweep the excess flat with a knife; packing flour tightly will double the actual weight of the recipe."
        ),
        Utensil(
            id = "measuring-spoons",
            name = "Measuring Spoons",
            phonetic = "/ˈmɛʒ.ər.ɪŋ spuːnz/",
            category = "measuring",
            materials = listOf("Stainless Steel", "Plastic"),
            altNames = listOf("Spice Spoons"),
            useCase = "Small spoons calibrated in fractions of tablespoons and teaspoons. Perfect for adding accurate volumes of salt, baking powder, and spices.",
            funFact = "Liquid ingredients dome up slightly on spoons due to surface tension, so measure them flush over small pinch bowls."
        ),
        Utensil(
            id = "liquid-measuring-cup",
            name = "Liquid Measuring Cup",
            phonetic = "/ˈlɪk.wɪd ˈmɛʒ.ər.ɪŋ kʌp/",
            category = "measuring",
            materials = listOf("Glass", "Plastic"),
            altNames = listOf("Pyrex Jug", "Measuring Jug"),
            useCase = "A spouted glass pitcher with graduated marks on the sides, designed for measuring water, milk, stocks, or oil by eye level.",
            funFact = "Liquid cups feature a pour spout and extra space above the top line to prevent spills, unlike dry cups which are filled flat."
        ),
        Utensil(
            id = "kitchen-scale",
            name = "Kitchen Scale",
            phonetic = "/ˈkɪtʃ.ən skeɪl/",
            category = "measuring",
            materials = listOf("Plastic", "Glass", "Stainless Steel"),
            altNames = listOf("Digital Scale", "Food Scale"),
            useCase = "An electronic scale used to weigh ingredients in ounces or grams. Incredibly critical for professional bakers requiring exact weight ratios.",
            funFact = "The 'tare' button on a digital scale subtracts the weight of empty mixing bowls, letting you measure nested flour directly."
        ),
        Utensil(
            id = "instant-read-thermometer",
            name = "Instant-Read Thermometer",
            phonetic = "/ˈɪn.stənt riːd θəˈmɒm.ɪ.tər/",
            category = "measuring",
            materials = listOf("Stainless Steel", "Plastic"),
            altNames = listOf("Meat Thermometer", "Digital Probe"),
            useCase = "A digital probe poked into the center of thick steaks or roasts to immediately verify internal temperature doneness safely.",
            funFact = "Instant-read thermometers are the only foolproof way to prevent dry, overcooked poultry breast meat."
        ),
        Utensil(
            id = "colander",
            name = "Colander",
            phonetic = "/ˈkɒl.ɪn.dər/",
            category = "straining",
            materials = listOf("Stainless Steel", "Plastic", "Enamel"),
            altNames = listOf("Pasta Strainer", "Drainer bowl"),
            useCase = "A perforated bowl with handles. Used to wash produce or quickly strain hot boiling water off pasta, potatoes, and boiled foods.",
            funFact = "The word colander stems from the Latin word 'colum', which translates literally to 'sieve'."
        ),
        Utensil(
            id = "fine-mesh-strainer",
            name = "Fine Mesh Strainer",
            phonetic = "/faɪn mɛʃ ˈstreɪ.nər/",
            category = "straining",
            materials = listOf("Stainless Steel", "Plastic"),
            altNames = listOf("Sieve", "Tea Strainer"),
            useCase = "A deep bowl made of woven steel wire mesh. Perfect for filtering seeds from raspberry purees, sifting powdered sugar, or rinsing quinoa.",
            funFact = "A fine mesh strainer is highly critical in cocktails, catching tiny shards of crushed ice during a shake."
        ),
        Utensil(
            id = "salad-spinner",
            name = "Salad Spinner",
            phonetic = "/ˈsæl.əd ˈspɪn.ər/",
            category = "straining",
            materials = listOf("Plastic"),
            altNames = listOf("Lettuce Dryer"),
            useCase = "A plastic bowl containing a nested strainer basket that spins at high speeds via a pull-cord or crank lid, drying leafy greens centrifugally.",
            funFact = "Drying salad greens with a spinner is vital because oily dressings will slide right off wet greens instead of clinging to them."
        ),
        Utensil(
            id = "funnel",
            name = "Funnel",
            phonetic = "/ˈfʌn.əl/",
            category = "straining",
            materials = listOf("Plastic", "Stainless Steel", "Silicone"),
            altNames = listOf("Pouring Cone"),
            useCase = "A wide-mouthed cone tapering into a narrow tube. Helps pour hot stocks, oils, or powders into narrow-necked bottles without mess.",
            funFact = "Some funnels feature small air channels on the outer tube, letting air escape from bottles for faster pouring."
        ),
        Utensil(
            id = "can-opener",
            name = "Can Opener",
            phonetic = "/kæn ˈəʊ.pən.ər/",
            category = "opening",
            materials = listOf("Stainless Steel", "Plastic/Rubber"),
            altNames = listOf("Tin Opener"),
            useCase = "A hand-cranked cutting wheel tool that slices open the rolled metal lids of tin cans.",
            funFact = "Modern safety can openers slice the outer seam rather than the top, leaving a smooth reusable lid without razor edges."
        ),
        Utensil(
            id = "bottle-opener",
            name = "Bottle Opener",
            phonetic = "/ˈbɒt.əl ˈəʊ.pən.ər/",
            category = "opening",
            materials = listOf("Stainless Steel", "Wood"),
            altNames = listOf("Cap Lifter", "Churchkey"),
            useCase = "A simple steel hook lever, used to pop pry-off crown caps off glass bottles.",
            funFact = "Often designed flat as 'speed openers' so bartenders can spin them out of back pockets instantly."
        ),
        Utensil(
            id = "corkscrew",
            name = "Corkscrew",
            phonetic = "/ˈcɔːk.skruː/",
            category = "opening",
            materials = listOf("Stainless Steel", "Plastic"),
            altNames = listOf("Wine Opener", "Winged Corkscrew"),
            useCase = "A coiled metal worm driven into wine bottle corks to pull them out smoothly.",
            funFact = "Winged corkscrews raise their metal arm levers as you twist the worm down; pressing down both arms pulls the cork out effortlessly."
        ),
        Utensil(
            id = "nutcracker",
            name = "Nutcracker",
            phonetic = "/ˈnʌt.kræk.ər/",
            category = "opening",
            materials = listOf("Stainless Steel", "Cast Zinc"),
            altNames = listOf("Cracker pliers"),
            useCase = "A heavy double-lever metal clamp with ridged teeth inside, used to crack walnuts, pecans, or crab claws open easily.",
            funFact = "The leverage multiplier of a nutcracker handles forces up to 200 pounds of pressure on nutshells."
        ),
        Utensil(
            id = "oven-mitts",
            name = "Oven Mitts",
            phonetic = "/ˈʌv.ən mɪts/",
            category = "opening",
            materials = listOf("Silicone", "Cotton Canvas"),
            altNames = listOf("Potholder", "Heat Mitts"),
            useCase = "Heavy padded gloves worn to shield hands from third-degree burns when lifting blistering baking pans out of the oven.",
            funFact = "Always check that your oven mitts are completely dry; damp mitts transmit heat instantly via steam, causing severe burns."
        ),
        Utensil(
            id = "trivet",
            name = "Trivet",
            phonetic = "/ˈtrɪv.ɪt/",
            category = "opening",
            materials = listOf("Cast Iron", "Wood", "Cork", "Silicone"),
            altNames = listOf("Hot Pad", "Heat Plate"),
            useCase = "A heat-resistant pad or metal ring positioned on countertops to protect wooden tables from hot pans directly off stoves.",
            funFact = "Historically, trivets were three-legged iron stands positioned directly inside fireplaces over hot glowing coals."
        ),
        Utensil(
            id = "skillet",
            name = "Skillet (Frying Pan)",
            phonetic = "/ˈskɪl.ɪt/",
            category = "vessels",
            materials = listOf("Cast Iron", "Stainless Steel", "Non-stick"),
            altNames = listOf("Frying Pan"),
            useCase = "A shallow, flat-bottomed pan with sloped sides. Ideal for high-heat rapid cooking like frying, searing steaks, and sauteing vegetables.",
            funFact = "Cast-iron skillets are heavily seasoned with baked-on fat polymer layers, rendering them naturally slick and chemical-free non-stick."
        ),
        Utensil(
            id = "saucepan",
            name = "Saucepan",
            phonetic = "/ˈsɔːs.pæn/",
            category = "vessels",
            materials = listOf("Stainless Steel", "Copper", "Anodized Aluminum"),
            altNames = listOf("Boiling Pan"),
            useCase = "A deep circular pan featuring straight high walls and a single long handle, designed to boil grains, sauces, or reductions safely.",
            funFact = "A saucepan is designed for vertical depth to maximize heat transfer through liquids while reducing quick evaporation rates."
        ),
        Utensil(
            id = "stockpot",
            name = "Stockpot",
            phonetic = "/ˈstɒk.pɒt/",
            category = "vessels",
            materials = listOf("Stainless Steel", "Aluminum"),
            altNames = listOf("Soup Pot"),
            useCase = "A deep, tall, high-capacity pot with two loop handles and a lid. Built to cook large batches of liquid stocks, stews, or pasta.",
            funFact = "A stockpot's tall and narrow shape reduces surface evaporation, allowing slow, deep simmering of bone broths without boiling dry."
        ),
        Utensil(
            id = "dutch-oven",
            name = "Dutch Oven",
            phonetic = "/dʌtʃ ˈʌv.ən/",
            category = "vessels",
            materials = listOf("Enameled Cast Iron"),
            altNames = listOf("French Oven", "Cocotte"),
            useCase = "A heavy, thick-walled cast-iron pot with tight-fitting lid. Exceptional at holding high heat for slow braising stews or baking sourdough bread.",
            funFact = "The heavy lid contains tiny spike drips on the inside, condensing cooking steam to self-baste roasts constantly."
        ),
        Utensil(
            id = "wok",
            name = "Wok",
            phonetic = "/wɒk/",
            category = "vessels",
            materials = listOf("Carbon Steel", "Cast Iron"),
            altNames = listOf("Stir-fry Pan"),
            useCase = "A deep, sloping bowl-like carbon steel pan with high heat conductivity. Excels at high-speed stir-frying of ingredients rapidly.",
            funFact = "A seasoned wok imparts a smoky, complex wok-hei aroma ('breath of the wok') which caramelizes food sugars at extreme heat."
        ),
        Utensil(
            id = "baking-sheet",
            name = "Baking Sheet (Sheet Pan)",
            phonetic = "/ˈbeɪ.kɪŋ ʃiːt/",
            category = "vessels",
            materials = listOf("Aluminum", "Stainless Steel"),
            altNames = listOf("Cookie Sheet", "Sheet Pan"),
            useCase = "A flat rectangular metal pan featuring a shallow raised lip edge, used for roasting vegetables, baking cookies, or oven-broiling items.",
            funFact = "Professional kitchens rely heavily on 'half-sheets' which fit standard commercial racks perfectly."
        ),
        Utensil(
            id = "muffin-tin",
            name = "Muffin Tin",
            phonetic = "/ˈmʌf.ɪn tɪn/",
            category = "vessels",
            materials = listOf("Aluminized Steel", "Silicone"),
            altNames = listOf("Muffin Pan", "Cupcake Tray"),
            useCase = "A rectangular metal sheet containing a grid of circular cup depressions. Used to bake muffins, cupcakes, or individual savory tarts.",
            funFact = "You can grease muffin cups with butter, but paper cupcake liners are best to keep cakes soft and easy to pull out."
        ),
        Utensil(
            id = "casserole-dish",
            name = "Casserole Dish",
            phonetic = "/ˈcæs.ə.rəʊl dɪʃ/",
            category = "vessels",
            materials = listOf("Ceramic", "Stoneware", "Pyrex Glass"),
            altNames = listOf("Baking Dish", "Lasagna Pan"),
            useCase = "A deep rectangular ceramic baking dish featuring handles. Used to bake hearty slow casseroles, lasagnas, cobblers, and roasted items.",
            funFact = "The word casserole stems from an old Provençal word meaning a clay cooking pot or ladle."
        )
    )
}
