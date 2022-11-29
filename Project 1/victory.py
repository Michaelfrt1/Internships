def find_winner(board):
    vert_result = vertical(board)
    hor_result = horizontal(board)
    diag_result = diagonal(board)
    
    if(vert_result != None):
        return vert_result
    elif (hor_result != None):
        return hor_result
    elif (diag_result != None):
        return diag_result
    else:
        return 'Draw' # returns a draw if no one wins


def vertical(board):
    for i in range(3):
        dict = {}
        for j in range(3):
            if board[j][i] in dict:
                dict[board[j][i]] += 1
            else:
                dict[board[j][i]] = 1
        if len(dict) == 1:
            return board[0][i]

    return None

def horizontal(board):
    for i in range(3):
        dict = {}
        for j in range(3):
            if board[i][j] in dict:
                dict[board[i][j]] += 1
            else:
                dict[board[i][j]] = 1
        if len(dict) == 1:
            return board[i][0]
    
    return None

def diagonal(board):
    dict = {}
    for i in range(3):
        if board[i][i] in dict:
                dict[board[i][i]] += 1
        else:
                dict[board[i][i]] = 1
    if len(dict) == 1:
        return board[0][0]

    dict = {}
    for i in range(3):
        if board[i][2-i] in dict:
                dict[board[i][2-i]] += 1
        else:
                dict[board[i][2-i]] = 1
    if len(dict) == 1:
        return board[0][2]

    return None
