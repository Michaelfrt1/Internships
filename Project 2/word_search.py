RIGHT=(1, 0)       # to go right add 1 to x
DOWN=(0,1)         # to go down add 1 to y
RIGHT_DOWN=(1, 1)  # to go right_down add 1 to both x and y
RIGHT_UP=(1,-1)    # to go right_up add 1 to x and subtract 1 from y
DIRECTIONS = (RIGHT, DOWN, RIGHT_DOWN, RIGHT_UP)

def get_size(word_grid):
    """ The get_size function inputs list of lists and returns a tuple with, the first element being the width anmd the second element being the height.
    The width is represented by the number of elements in one sublist, and the height is represented by the number of sublists."""

    height = len(word_grid)
    width = 0
    for lst in word_grid:
        width += len(lst)
    width = int(width / height)
    size = (width, height)
    return size
    
def print_word_grid(word_grid):
    """The print_word_grid function inputs a list of lists and returns it in string format.
    It is also formats the list to look like a grid."""

    for lst in word_grid:
        lst = ''.join(lst)
        print(lst)
    print()

def copy_word_grid(word_grid):
    """The print_word_grid function inputs a list of lists and returns a copy of that said list without changing the parameter put in."""

    copy_grid = []
    for lst in word_grid:
        copy_grid.append(lst[:])
    return copy_grid
    
def extract(grid, position, direction, max_len):
    """The extract function inputs a grid(list of lists), a positon(tuple(x,y)) on said grid, the direction variables, and the max length of the word.
    The extract function than returns a string from grid by starting at the position and moving through the grids using the direction inputed.
    It then stops the function when it gets to max_len and returns the letters that were in that space"""

    letters = ''
    (x, y) = position
    size = get_size(grid)
   
    for letter in range(max_len):
        if 0 <= x and x < size[0] and 0 <= y and y < size[1]:
            letters += grid[y][x]
            x += direction[0]
            y += direction[1]
    
    return letters
    
def find(word_grid, word):
    """The find function inputs a grid(list of lists), and the desired word that we want to see is in the grid.
    If the word is not in the grid it will return None.
    If the word is in the grid then it will return the place in the grid where the word starts and the direction the word is heading."""

    for y in range(len(word_grid)):

        for x in range(len(word_grid[0])):
            if extract(word_grid, (x, y), RIGHT, len(word)) == word:
                return (x, y), RIGHT
            elif extract(word_grid, (x, y), DOWN, len(word)) == word:
                return (x, y), DOWN
            elif extract(word_grid, (x, y), RIGHT_DOWN, len(word)) == word:
                return (x, y), RIGHT_DOWN  
            elif extract(word_grid, (x, y), RIGHT_UP, len(word)) == word:
                return (x, y), RIGHT_UP
                
    return None   
  
def show_solution(word_grid, word):
    """The show solution function inputs a grid and the desired word.
    If the word is in the grid a statement will print capitilizing the word and stating "can be found as below" afterwards.
    It will then print out the grid inputed with the desired word highlighted in capital letters,
    If the word isn't in the grid it will print out the word and the statement "is not found in this word search" afterwards."""
    
    solution = find(word_grid, word)
    if solution != None:

        print(word.upper() + " can be found as below")
        
        answer_key = copy_word_grid(word_grid)
        cap_count = 0
        x = solution[0][0]
        y = solution[0][1]

        while cap_count < len(word):
            answer_key[y][x] = answer_key[y][x].upper()
            x += solution[1][0]
            y += solution[1][1]
            cap_count += 1
        
        print_word_grid(answer_key)
    
    else:
        print(word + " is not found in this word search")

def make_empty_grid(width, height):
    """The make_empty_grid function inputs a width and a height in integer form. height being the number of sublists, and width being the number of elements in one sublist.
    It returns an empy grid filled with question marks."""

    empty_grid = []

    for lst in range(height):
        empty_grid.append([])
        for ele in range(width):
            empty_grid[lst].append("?")
    
    return empty_grid

def can_add_word(word_grid, word, position, direction):
    """The can_add_word function inputs a grid the, desired word, the desired position where that word will be added, and the direction the word will go."""
    """This function checks if the word can be added to the grid taking in account the grids size, the words size, the words position, and the words direction.
    returns true if it can be added and false if it cant."""

    word_length = len(word)
    if direction[0] * word_length + position[0] > len(word_grid[0]) or  direction[0] * (word_length - 1) + position[0] < 0:
        return False
    elif direction[1] * word_length + position[1] > len(word_grid) or direction[1] * (word_length-1) + position[1] < 0:
        return False
    
    x = position[0]
    y = position[1]

    for char in word:
        
        if word_grid[y][x] != "?" and char != word_grid[y][x]:

            return False
        x += direction[0]
        y += direction[1]
    
    return True
        
def do_add_word(word_grid, word, position, direction):
    """The do_add_functrion is a helper function for the add_word function.
    This function doesn't return anythin but it changes the word grid character at the desired location"""

    x = position[0]
    y = position[1]

    for char in word:
        word_grid[y][x] = char
        x += direction[0]
        y += direction[1]

def fill_blanks(word_grid):
    """The fill_blanks function gets inputted a word_grid and fills all elements in that word grid that are question marks with a random letter character.
    All elements in the grid that aren't ?, stay the same."""

    for lst in range(len(word_grid)):
        for ele in range(len(word_grid[0])):
            if word_grid[lst][ele] == "?":
                word_grid[lst][ele] = random.choice(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l','m', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x','y', 'z'])
    
def add_word(word_grid, word):
    ''' Attempts to use the do_add word functrion in order to add the word in a random place on the grid.'''

    width, height = get_size(word_grid)
    for attempt_num in range(50):
        direction = random.choice(DIRECTIONS)
        x = random.randrange(width)
        y = random.randrange(height)
        location = (x, y)
        if can_add_word(word_grid, word, location, direction):
            do_add_word(word_grid, word, location, direction)
            return True
    return False

def generate(width, height, words):
    """The generate function generates a word grid using the width(element in one sublist), and the height(number of sublists), 
    and a list of the desired words that will be scattered throughout the grid."""

    words_actual = []
    word_grid = make_empty_grid(width, height)
    for word in words:
        if add_word(word_grid, word):
            words_actual.append(word)
    fill_blanks(word_grid)
    return word_grid, words_actual


if __name__ == "__main__":
#     print(get_size([["a", "b", "c"], ["c", "d", "q"]]))
#     print_word_grid([["a", "b", "c"], ["c", "d", "q"]])
#     grid1 = [["a", "b", "c"], ["c", "d", "q"]]
#     grid2 = copy_word_grid(grid1)
#     grid1 [0][0] = 'z'
#     print_word_grid(grid1)
#     print_word_grid(grid2)
#     grid3 = [["a", "b", "c"], ["c", "d", "q"],["a", "b", "c"], ["c", "d", "q"],["a", "b", "c"], ["c", "d", "q"]]
#     print("")
#     print_word_grid(grid3)
    
   
#     show_solution(grid3, "adc")
#     print("")
#     print(extract(grid3, (0,0), DOWN, 3) )
#     grid = make_empty_grid (3,2)
#     print_word_grid(grid)

#     grid [0][0] = 'q'
#     grid [0][1] = 'k'
#     print_word_grid(grid)
#     print(can_add_word(grid,'abc',(2,0),RIGHT))
#     (fill_blanks(grid))
#     print("")
#     print(grid)
#     grid, words = generate(10, 10, ["java", "python", "list", "set", "tuple","string"])
#     print_word_grid(grid)
    
#     print(show_solution(grid, "python"))
#     print(show_solution(grid, "java"))
#     print(show_solution(grid, "list"))
#     print(show_solution(grid, "set"))
#     print(show_solution(grid, "tuple"))
#     print(show_solution(grid, "string"))
