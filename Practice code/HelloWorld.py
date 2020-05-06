import pickle


global oneJob
# oneJob = "Magnus, don't tear down that wall!"
#
# pickle_out = open("TheMessage.pickle", "wb")
# pickle.dump(oneJob, pickle_out)
# pickle_out.close()

pickle_in = open("TheMessage.pickle", "rb")
oneJob = (pickle.load(pickle_in))

print(oneJob)