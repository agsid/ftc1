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
        green_ball = None
        purple = [ball1, ball2, ball3]
        return None
    return green_ball

green(ball1, ball2, ball3)

# Build the shooting order
if sequence == "GPP":
    shoot = [green_ball, purple[0], purple[1]]
elif sequence == "PGP":
    shoot = [purple[0], green_ball, purple[1]]
elif sequence == "PPG":
    shoot = [purple[0], purple[1], green_ball]

print("Shoot order:", shoot)


final = input("Enter key to shoot (f:green, h:purple, g:all in sequence): ")

if final == "g":
    print(shoot)
        shoot.pop([0,1,2])

    print("Remaining shoot list:", shoot)

elif final == "h":
    purple_ball = purple[0]
    print(f"Rotate to {purple_ball[1]}° to shoot {purple_ball[2]}")
    print("Shooting:", purple_ball)

    if purple_ball in shoot:
        shoot.remove(purple_ball)

    purple.pop(0)

    print("Remaining shoot list:", shoot)

# ---------------------------------------------------
# SHOOT GREEN BALL
# ---------------------------------------------------
elif final == "f":
    if green_ball:
        print(f"Rotate to {green_ball[1]}° to shoot {green_ball[2]}")
        print("Shooting green:", green_ball)

        if green_ball in shoot:
            shoot.remove(green_ball)

        green_ball = None

    print("Remaining shoot list:", shoot)

else:
    print("wrong key")
