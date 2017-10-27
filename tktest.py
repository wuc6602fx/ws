import tkinter as tk 
win = tk.Tk()
win.title("TK GUI")

label = tk.Label(win, text="Hello")
label.pack()

button = tk.Button(win, text="Press")
button.pack()

entry = tk.Entry(win, text="Entry")
entry.pack()

win.mainloop()
