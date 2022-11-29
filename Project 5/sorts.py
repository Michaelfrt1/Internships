# Selection, Insertion, and Merge sorts
# Which one runs better



def selection_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers)"""
    count = 0
    for i in range(len(numbers) - 1):
        # Find index of smallest remaining element
        index_smallest = i
        for j in range(i + 1, len(numbers)):
            count+=1
            if numbers[j] < numbers[index_smallest]:
                index_smallest = j
                

        # Swap numbers[i] and numbers[index_smallest]
        temp = numbers[i]
        numbers[i] = numbers[index_smallest]
        numbers[index_smallest] = temp

    return count

def insertion_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers)"""
    count = 0
    for i in range(1, len(numbers)):
        
        j = i
        # Insert numbers[i] into sorted part
        # stopping once numbers[i] in correct position
        count+=1
        while j > 0 and numbers[j] < numbers[j - 1]:
            count+=1
            # Swap numbers[j] and numbers[j - 1]
            temp = numbers[j]
            numbers[j] = numbers[j - 1]
            numbers[j - 1] = temp
            j = j - 1
    return count
    
def merge(numbers, i, j, k):
    count = 0
    """ Given two sorted sub-lists creates one sorted list. This is done in-place, meaning I'm giving one list
    and expected to modify the list to be sorted. Furthermore, this operates on "sub-lists" (a specific range of the list)
    The list named numbers may contain other types of data than just numbers
    the variables i, j, and k are all indices into the numbers list
    So so the part of the list to be sorted is from position i to k (inclusive) with i to j being one sorted list, and j+1 to k being another."""
    merged_size = k - i + 1   #  Size of merged partition
    merged_numbers = []        #  Temporary list for merged numbers
    for l in range(merged_size):
        merged_numbers.append(0)

    merge_pos = 0      #  Position to insert merged number

    left_pos = i       #  Initialize left partition position
    right_pos = j + 1  #  Initialize right partition position

    #  Add smallest element from left or right partition to merged numbers

    while left_pos <= j and right_pos <= k:
        count+=1
        if numbers[left_pos] < numbers[right_pos]:
            merged_numbers[merge_pos] = numbers[left_pos]
            left_pos = left_pos + 1
        else:
            merged_numbers[merge_pos] = numbers[right_pos]
            right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  If left partition is not empty, add remaining elements to merged numbers
    while left_pos <= j:
        merged_numbers[merge_pos] = numbers[left_pos]
        left_pos = left_pos + 1
        merge_pos = merge_pos + 1

    #  If right partition is not empty, add remaining elements to merged numbers
    while right_pos <= k:
        merged_numbers[merge_pos] = numbers[right_pos]
        right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  Copy merge number back to numbers
    merge_pos = 0
    while merge_pos < merged_size:
        numbers[i + merge_pos] = merged_numbers[merge_pos]
        merge_pos = merge_pos + 1

    return count

def merge_sort_recursive(numbers, i, k):
    count = 0
    """ Sort the sub-list in numbers from position i to k (inclusive)"""
    if i < k:
        
        j = (i + k) // 2  #  Find the midpoint in the partition
      
        count += merge_sort_recursive(numbers, i, j)

        count += merge_sort_recursive(numbers, j + 1, k)
        
        #  Merge left and right partition in sorted order
        count += merge(numbers, i, j, k)
        
    return count
def merge_sort(numbers):
    
    """ Sort a list of numbers

    This function is added on-top to simply start the recursive process with the
    appropriate parameters. This also gives us a consistent sorting interface over the three sorts."""
    return merge_sort_recursive(numbers, 0, len(numbers)-1)
    
