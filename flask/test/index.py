from flask import Flask, render_template, request
from mf import run

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/result', methods=['POST'])
def login():
    a = request.form['a']
    x,y = run()
    x = x+int(a)
    return render_template('result.html', x=x,y=y)

if __name__ == '__main__':
    app.run(debug=True)
