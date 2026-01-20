def currentpos():
    x = 12
    return x

rotate = currentpos()
ball1 = [input("Ball1 Color : "), rotate, "ball1"]
rotate += 120
ball2 = [input("Ball2 Color : "), rotate, "ball2"]
rotate += 120
ball3 = [input("Ball3 Color : "), rotate, "ball3"]

shoot = []
sequence = input("s : ")
purple = []
green_ball = None

def green(ball1, ball2, ball3):
    global green_ball, purple
    if ball1[0] == "Green":
        green_ball = ball1
        purple = [ball2, ball3]
    elif ball2[0] == "Green":
        green_ball = ball2
        purple = [ball1, ball3]
    elif ball3[0] == "Green":
        green_ball = ball3
        purple = [ball1, ball2]
    else:
        green_ball = ["None"]
        purple = [ball1, ball2, ball3]
        return None
    print(green_ball)
    return green_ball

green(ball1, ball2, ball3)

if sequence == "GPP":
    shoot = [green_ball, purple[0], purple[1]]
    print(shoot)
if sequence == "PGP":
    shoot = [purple[0], green_ball, purple[1]]
    print(shoot)
if sequence == "PPG":
    shoot = [purple[0], purple[1], green_ball]
    print(shoot)
    
final = input("Enter the Key to shoot f:green h:purple g:allin sequence: ")
if final == "g":
    print(shoot)
    if shoot:
        del shoot[0]
    print(shoot)
elif final == "h":
    print(purple[0])
    if purple:
        del purple[0]
    print(shoot)
elif final == "f":  
    print(green_ball)
    if green_ball and len(green_ball) > 0:
        del green_ball[0]
    print(shoot)
else:
    print("wrong key")
