
def ConvertImage(ImageName):
    from PIL import Image
    import numpy as np

    # Open the maze image and make greyscale, and get its dimensions
    im = Image.open(ImageName).convert('L')
    #im.show()
    w, h = im.size

    # Ensure all black pixels are 0 and all white pixels are 1
    binary = im.point(lambda p: p < 128 and 1)

    # Resize to half its height and width so we can fit on Stack Overflow, get new dimensions
    binary = binary.resize((w//2,h//2),Image.NEAREST)
    w, h = binary.size

    # Convert to Numpy array - because that's how images are best stored and processed in Python
    nim = np.array(binary)
    
    # Each cell of the maze is represented by 5 numbers. Therefore change scaling FROM (5 number: 1 cell) TO (1 numer: 1 cell)
    # initialize maze matrix
    maze = [[0 for i in range(int(w/5))] for j in range(int(h/5))]

    # go through every 5th number in each row and add it sequencially to the new matrix (maze).
    ri = ci = 0
    r = c = 4

    while ri < h/5:
        ci = 0
        c = 4
        while ci < w/5:
            maze[ri][ci] = nim[r][c]
            # print(maze[ri][ci], end='')            # FOR TESTING PURPOSE PRINT FINAL MAZE MATRIX 
            ci += 1
            c += 5
        # print()
        ri += 1
        r += 5

    # print("\n\n")

    return [maze,int(h/5),int(w/5)]


"""
    for r in range(4, h, 5):
        for c in range(4, w, 5):
            print(nim[r,c],end='')
        print()

ConvertImage('maze.png')
"""
