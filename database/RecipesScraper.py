from recipe_scrapers import scrape_me



i = 0
for i in range(14117, 16000):
    print("Executing " + str(i))
    

    scraper = scrape_me("https://www.allrecipes.com/recipe/" + str(i) + "/")
    instruct = scraper.instructions()
    if str(instruct) != "":
        text_file_1 = open("files2/" + str(i) + "_title.txt", 'w')
        text_file_2 = open("files2/" + str(i) + "_time.txt", 'w')
        text_file_3 = open("files2/" + str(i) + "_ingred.txt", 'w')
        text_file_4 = open("files2/" + str(i) + "_instruct.txt", 'w')
        text_file_5 = open("files2/" + str(i) + "_img.txt", 'w')
        title = scraper.title()
        total_time = scraper.total_time()
        ingred = scraper.ingredients()  
        instruct = scraper.instructions()
        img = scraper.image()
    
        text_file_1.write(str(title))
        text_file_2.write(str(total_time))
        text_file_3.write(str(ingred))
        text_file_4.write(str(instruct))
        text_file_5.write(str(img))
    
        text_file_1.close()
        text_file_2.close()
        text_file_3.close()
        text_file_4.close()
        text_file_5.close()