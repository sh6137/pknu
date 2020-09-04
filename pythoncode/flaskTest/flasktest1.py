from flask import Flask,render_template,request
app = Flask(__name__)
@app.route('/')
def index():
    return render_template('index.html')

@app.route('/user/<username>')
def show_user_profile(username):
    return 'username %s' %username

@app.route('/user/<username>/<int:age>')
def show_user_age_profile(username,age):
    return 'username %s age %d' %(username,age)

@app.route('/input')
def input():
    return render_template('input.html')

@app.route('/method',methods=['GET','POST'])
def login():
    if request.method == 'POST':
        email = request.form['email']
        password =request.form['password']
        return 'email : %s password : %s'%(email. password) 
    else:
        email = request.args.get('email')
        return 'email : %s' %email
if __name__ =='__main__':
    app.run(debug=True, port=80)
