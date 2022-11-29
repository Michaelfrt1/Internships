def miles_run(file_name, member):
    try:
        fp = open(file_name)
        fp.readline() #skip past header line

        run_dict = {}
        for line in fp.readlines():
            member_lst = line.split(",")
            if member_lst[0] in run_dict:
                run_dict[member_lst[0]] += int(member_lst[1])
            else:
                run_dict[member_lst[0]] = int(member_lst[1])
        
        fp.close()

        if member in run_dict:
            return run_dict[member]
        else:
            return 0
    
    except FileNotFoundError: #If no file name is in the homework folder
        return -1
    
