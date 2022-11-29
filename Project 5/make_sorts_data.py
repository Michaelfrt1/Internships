from sorts import *
import random

if __name__ == "__main__":

    for list_type in ["sorted_list", "near_sorted", "random", "backwards"]:
        out_csv = open(list_type+".csv", "w")
        print("working on "+list_type+".csv")
        print('length', 'selection', 'insertion', 'merge', sep=", ", file = out_csv)
        for length in range(10, 1250, 15):
            lst = list(range(length))
            if list_type == "near_sorted":
                for i in range(length):
                    a = random.randrange(length-1)
                    lst[a], lst[a+1] = lst[a+1], lst[a]
            elif list_type == "random":
                random.shuffle(lst)
            elif list_type == "backwards":
                lst = lst[::-1]
            selection = selection_sort(lst[:])
            insertion = insertion_sort(lst[:])
            merge = merge_sort(lst[:])
            print(length, selection, insertion, merge, sep=", ", file=out_csv)
        out_csv.close()
        print("done")
