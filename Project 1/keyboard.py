def flag_keys(phrase, max_repeat = 2): # defualt paramater max repeat = 2
    try:
        lst = []
        phrase = phrase.split(" ")
        for word in phrase:
            
            for i in range(len(word) - 1):
                if(word[i] == word[i+1]):
                    count_repeats = 1
                    j = i+1 # next letter to compare too
                    while (j < len(word)-1 and word[j] == word[j+1]):
                        count_repeats += 1
                        j += 1

                    if count_repeats >= max_repeat:
                        lst.append(word[i])
                
                

        new_lst = [] # if letter already mentioned doesn't add to list
        for letter in lst:
            if letter not in new_lst:
                new_lst.append(letter)


        return new_lst
            

    
    except IndexError:
        print("IndexError")
