import pika

# connect to RabbitMQ server, same as send.py
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# create queue
channel.queue_declare(queue='hello')

# make a callback function
def callback(ch, method, properties, body):
    print " [x] Received %r" % (body,)

# notify server use it as callback
channel.basic_consume(callback, queue='hello', no_ack=True)

# start to receive
channel.start_consuming()
