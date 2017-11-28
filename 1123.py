from flask import Flask
app = Flask(__name__)
@app.route("/")
def hello():
    return "Hello World!"
@app.route("/<name>")
def hey(name):
    return "Hey, %s"%name

if __name__ == "__main__":
    app.run()
