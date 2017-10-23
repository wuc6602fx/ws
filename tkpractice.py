from tkinter import *   # sudo apt-get install python3-tk, and run with command python3


class GUIDemo(Frame):
    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.grid()
        self.createWidgets()

    def createWidgets(self):
        self.inputText = Label(self)
        self.inputText["text"] = 'Inputs:'
        self.inputText.grid(row=0, column=0, columnspan=6)
        self.inputField = Entry(self)
        self.inputField["width"] = 50
        self.inputField.grid(row=0, column=0, columnspan=6)


if __name__ == '__main__':
    root = Tk()
    app = GUIDemo(master=root)
    app.mainloop()
